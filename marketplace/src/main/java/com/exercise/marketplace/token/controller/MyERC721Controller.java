package com.exercise.marketplace.token.controller;

import java.util.List;

import com.exercise.marketplace.token.request.MyERC721Request;
import com.exercise.marketplace.token.service.MyERC721Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("erc721")
public class MyERC721Controller {
    
    private MyERC721Service service;

    // @Autowired
    // public MyERC721Controller(MyERC721Service service) {
    //     this.service = service;
    // }
    
    // // 발행
    // @PostMapping("/mint")
    // public String mint(@RequestBody MyERC721Request request) throws Exception {
    //     return service.mint(request);
    // }

    // // 전송
    // @PostMapping("/transfer")
    // public String transfer(@RequestBody MyERC721Request request) throws Exception {
    //     return service.transfer(request);
    // }

    // // 보유중인 토큰 목록
    // @PostMapping("/tokens")
    // public List<String> getTokens(@RequestBody MyERC721Request request) throws Exception {
    //     return service.getTokens(request);
    // }
}
