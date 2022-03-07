package com.exercise.marketplace.token.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("erc721")
public class MyERC721Controller {
    
    // private MyERC721Service service;

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
