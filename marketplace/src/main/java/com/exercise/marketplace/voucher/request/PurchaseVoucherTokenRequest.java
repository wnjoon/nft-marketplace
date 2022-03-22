package com.exercise.marketplace.voucher.request;

public class PurchaseVoucherTokenRequest {
    private String myId;
    private String voucherTokenId;
    private String amount;

    public PurchaseVoucherTokenRequest() {}

    public PurchaseVoucherTokenRequest(String myId, String voucherTokenId, String amount) {
        this.myId = myId;
        this.voucherTokenId = voucherTokenId;
        this.amount = amount;
    }
    
    public String getMyId() {
        return this.myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getVoucherTokenId() {
        return this.voucherTokenId;
    }

    public void setVoucherTokenId(String voucherTokenId) {
        this.voucherTokenId = voucherTokenId;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
