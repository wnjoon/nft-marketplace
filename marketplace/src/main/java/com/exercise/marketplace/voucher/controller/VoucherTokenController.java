package com.exercise.marketplace.voucher.controller;

import com.exercise.marketplace.voucher.request.VoucherTokenRequest;
import com.exercise.marketplace.voucher.service.VoucherTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("voucher")
public class VoucherTokenController {
    
    @Autowired
    private VoucherTokenService service;

    @PostMapping("mint")
    public String mint(@RequestBody VoucherTokenRequest request) throws Exception {
        return service.mintVoucherToken(request);
    } 
}
