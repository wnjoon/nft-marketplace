package com.exercise.marketplace.voucher.service;

import java.math.BigInteger;

import javax.annotation.PostConstruct;

import com.exercise.contract.VoucherToken;
import com.exercise.marketplace.user.model.UserInfo;
import com.exercise.marketplace.user.service.UserService;
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

    private String voucherTokenAddress;

    @PostConstruct
    public void setupTokenContract() throws InterruptedException {
        voucherTokenAddress = env.getProperty("ca.voucher");
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
            return receipt.toString();
        }
        return null;
    } 
}
