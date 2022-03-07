package com.exercise.marketplace.token.service;

import java.math.BigInteger;

import javax.annotation.PostConstruct;

import com.exercise.contract.MyERC20;
import com.exercise.marketplace.token.request.MyERC20Request;
import com.exercise.marketplace.user.model.UserInfo;
import com.exercise.marketplace.user.service.UserService;
import com.exercise.util.NetworkConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service("myERC20Service")
public class MyERC20Service {

    @Autowired
    private Environment env; 

    @Autowired
    private UserService userService;

    private String erc20Address;

    @PostConstruct
    public void setupTokenContract() throws InterruptedException {
        erc20Address = env.getProperty("ca.erc20");
    }
    
    /*
     * getBalance
     * 계정의 잔여 ERC20 토큰 갯수 조회
     */
    public BigInteger getBalance(MyERC20Request request) throws Exception {
       
        UserInfo user = userService.getUser(request.getMyId());        

        System.out.println(user.toString());

        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());
        
        MyERC20 token = MyERC20.load(
            erc20Address, // request.getErc20Address(),
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        return token.balanceOf(user.getAddress()).send();
    }

    /*
     * transfer
     * ERC20을 계정 간 전송
     */
    public String transfer(MyERC20Request request) throws Exception {
        
        UserInfo sender = userService.getUser(request.getMyId());
        BigInteger amount = new BigInteger(request.getAmount());  
        
        if(getBalance(request).compareTo(amount) >= 0) {
            // 잔액이 충분한 경우에만 거래 진행
            UserInfo receiver = userService.getUser(request.getReceiverId());
            NetworkConnector nc = new NetworkConnector(sender.getPrivateKey());

            MyERC20 token = MyERC20.load(
                erc20Address,
                nc.getWeb3j(),
                nc.getManager(),
                nc.getGasProvider()    
            );

            TransactionReceipt receipt = token.transfer(receiver.getAddress(), amount).send();
            
            if(receipt.isStatusOK()) {
                return receipt.toString();
            }
        }
        return null;
    }
}
