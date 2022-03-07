package com.exercise.marketplace.token.request;

public class MyERC20Request {

    private String myId;
    private String receiverId;
    private String amount;

    public String getMyId() {
        return this.myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public MyERC20Request() {}
    
    /*
     * Request construct for transfer
     */
    public MyERC20Request(String myId, String receiverId, String amount) {
        this.myId = myId;
        this.receiverId = receiverId;
        this.amount = amount;
    }
    
    /*
     * Request construct for get balance
     */
    public MyERC20Request(String myId) {
        this.myId = myId;
    }

}
