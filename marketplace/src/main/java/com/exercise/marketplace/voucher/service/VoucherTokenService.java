package com.exercise.marketplace.voucher.service;

import java.math.BigInteger;

import javax.annotation.PostConstruct;

import com.exercise.contract.MoneyToken;
import com.exercise.contract.PurchaseVoucher;
import com.exercise.contract.VoucherToken;
import com.exercise.marketplace.user.model.UserInfo;
import com.exercise.marketplace.user.service.UserService;
import com.exercise.marketplace.voucher.request.PurchaseVoucherTokenRequest;
import com.exercise.marketplace.voucher.request.VoucherTokenRequest;
import com.exercise.util.NetworkConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service("voucherTokenService")
public class VoucherTokenService {
   
    @Autowired
    private Environment env;
    
    @Autowired
    private UserService userService;

    private String adminAddress;
    private String moneyTokenAddress;
    private String voucherTokenAddress;
    private String purchaseVoucherAddress;

    @PostConstruct
    public void setupTokenContract() throws InterruptedException {
        adminAddress = env.getProperty("admin.address");
        moneyTokenAddress = env.getProperty("ca.money");
        voucherTokenAddress = env.getProperty("ca.voucher");
        purchaseVoucherAddress = env.getProperty("ca.purchasevoucher");
    }

    /*
     * mintVoucherToken
     * 이용권 토큰 하나를 발행
     */
    public String mintVoucherToken(VoucherTokenRequest request) throws Exception {
        
        UserInfo user = userService.getUser(request.getMyId());        
        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());
        
        VoucherToken token = VoucherToken.load(
            voucherTokenAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        TransactionReceipt receipt = token.mint(
            voucherTokenAddress,
            env.getProperty("ca." + request.getArtworkName()),
            new BigInteger(request.getArtworkId()),
            request.getStartDate(),
            request.getEndDate()
        ).send();

        if(receipt.isStatusOK()) {

            // 만들어진 토큰의 ID 확인 -> Incremental 하므로 현재 존재하는 전체 토큰 갯수가 번호가 됨
            int voucherTokenId = token.totalSupply().send().intValue();
            // VoucherToken의 이동을 PurchaeVoucher 컨트랙트가 대행 -> approve
            // 미리 해놓음
            if(approveToPurchaseVoucherToken(token, voucherTokenId).isStatusOK()) {
                return receipt.toString();
            }

        // }
        // TransactionReceipt receipt = approveToPurchaseVoucherToken(token, 1);
        // if (receipt.isStatusOK()) {
        //     return receipt.toString();
        // }
        }
        return null;
    } 

     /*
     * purchaseVoucherToken
     * voucherToken 하나를 구매
     */
    public String purchaseVoucherToken(PurchaseVoucherTokenRequest request) throws Exception {
        UserInfo user = userService.getUser(request.getMyId());        
        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());

        PurchaseVoucher contract = PurchaseVoucher.load(
            purchaseVoucherAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        // MoneyToken의 이동을 PurchaseVoucher 컨트랙트가 대행 -> approve
        MoneyToken moneyToken = MoneyToken.load(
            moneyTokenAddress, 
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        TransactionReceipt approveToSendMoney = moneyToken.approve(
            purchaseVoucherAddress, 
            new BigInteger(request.getAmount())
        ).send();
        

        // [TO DO] : 0x0. Gas used: 26545. Revert reason: 'execution reverted: TransferHelper: TRANSFER_FROM_FAILED(MONEY TO ADMIN
        if(approveToSendMoney.isStatusOK()) {

            TransactionReceipt receipt = contract.purchaseVoucherToken(
                adminAddress,
                moneyTokenAddress,
                voucherTokenAddress,
                new BigInteger(request.getVoucherTokenId()),
                new BigInteger(request.getAmount())
            ).send();

            if(receipt.isStatusOK()) {
                return receipt.toString();
            }
            return null;
        }
        return null;
    }

    public TransactionReceipt approveToPurchaseVoucherToken(VoucherToken token, int voucherTokenId) throws Exception {
        // return token.approve(
        //     purchaseVoucherAddress,
        //     new BigInteger(Integer.toString(voucherTokenId))
        // ).send();
        return token.setApprovalForAll(purchaseVoucherAddress, true).send();
    }
}
