package com.exercise.marketplace.token.controller;

import java.util.List;

import com.exercise.marketplace.token.request.BanksyTokenRequest;
import com.exercise.marketplace.token.service.BanksyTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banksy")
public class BanksyTokenController {
    
    private BanksyTokenService service;

    @Autowired
    public BanksyTokenController(BanksyTokenService service) {
        this.service = service;
    }
    
    // 발행
    @PostMapping("/mint")
    public String mint(@RequestBody BanksyTokenRequest request) throws Exception {
        return service.mint(request);
    }

    // 보유중인 토큰 목록
    @PostMapping("/tokens")
    public List<String> getTokens(@RequestBody BanksyTokenRequest request) throws Exception {
        return service.getTokens(request);
    }

    // 잔고 수량 조회
    @PostMapping("/balance")
    public int balance(@RequestBody BanksyTokenRequest request) throws Exception {
        return service.getBalance(request);
    }

    // 전송
    @PostMapping("/transfer")
    public String transfer(@RequestBody BanksyTokenRequest request) throws Exception {
        return service.transfer(request);
    }

    // 토큰목록조회(테스트)
    @PostMapping("/printTokensOwner")
    public List<String> printTokensOwner(@RequestBody BanksyTokenRequest request) throws Exception {
        return service.printTokensOwner(request);
    }

}
