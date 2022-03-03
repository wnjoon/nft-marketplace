package com.exercise.token.controller;

import com.exercise.request.MyERC20Request;
import com.exercise.token.service.MyERC20Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("erc20")
public class MyERC20Controller {
    
    private MyERC20Service service;

    @Autowired
    public MyERC20Controller(MyERC20Service service) {
        this.service = service;
    }

    @PostMapping("balance") 
    public String getBalance(@RequestBody MyERC20Request request) throws Exception {
        return service.getBalance(request).toString();
    }

    @PostMapping("transfer")
    public String transfer(@RequestBody MyERC20Request request) throws Exception {
        return service.transfer(request);
    }
    
}
