package com.exercise.token.service;

import java.math.BigInteger;

import com.exercise.contract.MyERC20;
import com.exercise.request.MyERC20Request;
import com.exercise.util.NetworkConnector;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service("erc20Service")
public class MyERC20Service {
    
    /*
     * getBalance
     * 계정의 잔여 ERC20 토큰 갯수 조회
     */
    public BigInteger getBalance(MyERC20Request request) throws Exception {
        
        String myPrivateKey = request.getMyPrivateKey();

        NetworkConnector nc = new NetworkConnector(myPrivateKey);
        
        MyERC20 token = MyERC20.load(
            request.getErc20Address(),
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        return token.balanceOf(myPrivateKey).send();
    }

    /*
     * transfer
     * ERC20을 계정 간 전송
     */
    public String transfer(MyERC20Request request) throws Exception {
        
        BigInteger amount = new BigInteger(request.getAmount());  
        
        if(getBalance(request).compareTo(amount) >= 0) {
            // 잔액이 충분한 경우에만 거래 진행
            NetworkConnector nc = new NetworkConnector(request.getMyPrivateKey());

            MyERC20 token = MyERC20.load(
                request.getErc20Address(),
                nc.getWeb3j(),
                nc.getManager(),
                nc.getGasProvider()    
            );

            TransactionReceipt receipt = token.transfer(request.getOtherAddress(), amount).send();
            
            if(receipt.isStatusOK()) {
                return receipt.toString();
            }
        }
        return null;
    }
}
