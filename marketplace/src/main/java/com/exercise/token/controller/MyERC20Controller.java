package com.exercise.token.controller;

import com.exercise.token.service.MyERC20Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("erc20")
public class MyERC20Controller {

    @Autowired
    private MyERC20Service service;

    @Autowired
    private JsonResponser jsonResponser;    

    /*
     * getBalance
     * 잔여량 확인
     */
    @GetMapping("/balance")
    public 
    
}
