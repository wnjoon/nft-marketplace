package com.exercise.marketplace.token.controller;

import com.exercise.marketplace.token.request.MoneyTokenRequest;
import com.exercise.marketplace.token.service.MoneyTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money")
public class MoneyTokenController {
    
    private MoneyTokenService service;

    @Autowired
    public MoneyTokenController(MoneyTokenService service) {
        this.service = service;
    }

    @PostMapping("/balance") 
    public String getBalance(@RequestBody MoneyTokenRequest request) throws Exception {
        return service.getBalance(request).toString();
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody MoneyTokenRequest request) throws Exception {
        return service.transfer(request); 
    }
    
}
