package com.exercise.marketplace.token.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.exercise.contract.MyERC721;
import com.exercise.marketplace.token.request.MyERC721Request;
import com.exercise.util.NetworkConnector;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service("erc721Service")
public class MyERC721Service {
    
    /*
     * mint
     * 특정 계정에 ERC721 발행(minting)
     */
    // public String mint(MyERC721Request request) throws Exception {
        
    //     NetworkConnector nc = new NetworkConnector(request.getMyPrivateKey());
    //     MyERC721 token = MyERC721.load(
    //         request.getErc721Address(),
    //         nc.getWeb3j(),
    //         nc.getManager(),
    //         nc.getGasProvider()
    //     );

    //     TransactionReceipt receipt = token.mint(request.getMyAddress(), request.getUrl()).send();

    //     if(receipt.isStatusOK()) {
    //         return receipt.toString();
    //     }
    //     return null;
    // }

    // /*
    //  * getBalance
    //  * 계정의 잔여 ERC721 토큰 갯수 조회
    //  */
    // public BigInteger getBalance(MyERC721Request request) throws Exception {
        
    //     NetworkConnector nc = new NetworkConnector(request.getMyPrivateKey());
        
    //     MyERC721 token = MyERC721.load(
    //         request.getErc721Address(),
    //         nc.getWeb3j(),
    //         nc.getManager(),
    //         nc.getGasProvider()
    //     );

    //     return token.balanceOf(request.getMyAddress()).send();
    // }

    // /*
    //  * transfer
    //  * ERC721을 계정 간 전송
    //  */
    // public String transfer(MyERC721Request request) throws Exception {
        
    //     NetworkConnector nc = new NetworkConnector(request.getMyPrivateKey());

    //     MyERC721 token = MyERC721.load(
    //         request.getErc721Address(),
    //         nc.getWeb3j(),
    //         nc.getManager(),
    //         nc.getGasProvider()
    //     );

    //     BigInteger tokenId = new BigInteger(Integer.toString(request.getTokenId()));

    //     if(getTokenOwner(nc, token, tokenId).equals(request.getMyAddress())) {
    //         TransactionReceipt receipt = token.transferFrom(request.getMyAddress(), request.getOtherAddress(), tokenId).send();
            
    //         if(receipt.isStatusOK()) {
    //             return receipt.toString();
    //         }
    //     }

    //     return null;
    // }


    // /***** Utils *****/
    // /*
    //  * getTokenOwner
    //  * ERC721의 소유자 확인
    //  */
    // public String getTokenOwner(NetworkConnector nc, MyERC721 token, BigInteger tokenId) throws Exception {
    //     return token.ownerOf(tokenId).send();  
    // }

    // /*
    //  * getTokens
    //  * 특정 사용자가 보유하고 있는 ERC721 토큰 목록 
    //  */
    // public List<String> getTokens(MyERC721Request request) throws Exception {
        
    //     NetworkConnector nc = new NetworkConnector(request.getMyPrivateKey());

    //     MyERC721 token = MyERC721.load(
    //         request.getErc721Address(),
    //         nc.getWeb3j(),
    //         nc.getManager(),
    //         nc.getGasProvider()
    //     );

    //     int totalTokenCount = token.totalSupply().send().intValue();

    //     List<String> tokenList = new ArrayList<>();
    //     for(int i=1; i<=totalTokenCount; i++) {
    //         if(token.ownerOf(new BigInteger(Integer.toString(i))).send().equals(request.getMyAddress())) {
    //             tokenList.add(Integer.toString(i));
    //         }
    //     }

    //     return tokenList;
    // }
}
