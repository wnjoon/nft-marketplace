package com.exercise.marketplace.token.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.exercise.contract.BanksyToken;
import com.exercise.marketplace.token.request.BanksyTokenRequest;
import com.exercise.marketplace.user.model.UserInfo;
import com.exercise.marketplace.user.service.UserService;
import com.exercise.util.NetworkConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service("banksyTokenService")
public class BanksyTokenService {

    @Autowired
    private Environment env; 

    @Autowired
    private UserService userService;

    private String banksyTokenAddress;

    @PostConstruct
    public void setupTokenContract() throws InterruptedException {
        banksyTokenAddress = env.getProperty("ca.banksy");
    }
    
    /*
     * mint
     * 특정 계정에 ERC721 발행(minting)
     */
    public String mint(BanksyTokenRequest request) throws Exception {
        
        UserInfo user = userService.getUser(request.getMyId());        
        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());
        
        BanksyToken token = BanksyToken.load(
            banksyTokenAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        TransactionReceipt receipt = token.mint(request.getUrl()).send();

        if(receipt.isStatusOK()) {
            return receipt.toString();
        }
        return null;
    }

    /*
     * getTokens
     * 특정 사용자가 보유하고 있는 ERC721 토큰 목록 
     */
    public List<String> getTokens(BanksyTokenRequest request) throws Exception {
        
        UserInfo user = userService.getUser(request.getMyId());        
        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());

        BanksyToken token = BanksyToken.load(
            banksyTokenAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        int totalTokenCount = token.totalSupply().send().intValue();

        List<String> tokenList = new ArrayList<>();
        for(int i=1; i<=totalTokenCount; i++) {

            BigInteger tokenId = new BigInteger(Integer.toString(i));
            if(getTokenOwner(nc, token, tokenId).toLowerCase().equals(user.getAddress().toLowerCase())) {
                tokenList.add(Integer.toString(i));
            }
        }
        return tokenList;
    }

    /*
     * getBalance
     * 계정의 잔여 ERC721 토큰 갯수 조회
     */
    public int getBalance(BanksyTokenRequest request) throws Exception {
        
        UserInfo user = userService.getUser(request.getMyId());        
        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());

        BanksyToken token = BanksyToken.load(
            banksyTokenAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        return token.balanceOf(user.getAddress()).send().intValue();
    }

    /*
     * transfer
     * ERC721을 계정 간 전송
     */
    public String transfer(BanksyTokenRequest request) throws Exception {
        
        UserInfo sender = userService.getUser(request.getMyId());     
        UserInfo receiver = userService.getUser(request.getReceiverId());        
   
        NetworkConnector nc = new NetworkConnector(sender.getPrivateKey());

        BanksyToken token = BanksyToken.load(
            banksyTokenAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        BigInteger tokenId = new BigInteger(request.getTokenId());

        if(getTokenOwner(nc, token, tokenId).equals(sender.getAddress())) {

            TransactionReceipt receipt = token.transferFrom(sender.getAddress(), receiver.getAddress(), tokenId).send();
            
            if(receipt.isStatusOK()) {
                return receipt.toString();
            }
        }

        return null;
    }


    /***** Utils *****/
    /*
     * getTokenOwner
     * ERC721의 소유자 확인
     */
    public String getTokenOwner(NetworkConnector nc, BanksyToken token, BigInteger tokenId) throws Exception {
        return token.ownerOf(tokenId).send();  
    }

    /* 
     * Print Owner of minted tokens
     */
    public List<String> printTokensOwner(BanksyTokenRequest request) throws Exception {
        UserInfo user = userService.getUser(request.getMyId());     
        NetworkConnector nc = new NetworkConnector(user.getPrivateKey());

        BanksyToken token = BanksyToken.load(
            banksyTokenAddress,
            nc.getWeb3j(),
            nc.getManager(),
            nc.getGasProvider()
        );

        int totalTokenCount = token.totalSupply().send().intValue();

        List<String> tokenList = new ArrayList<>();
        for(int i=1; i<=totalTokenCount; i++) {
            BigInteger tokenId = new BigInteger(Integer.toString(i));
            tokenList.add(tokenId + " : " + getTokenOwner(nc, token, tokenId));
        }

        return tokenList;
    }
}
