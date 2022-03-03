package com.exercise.request;

public class MyERC20Request {

    private String erc20Address;
    private String myPrivateKey;
    private String myAddress;
    private String otherAddress;
    private String amount;

    public String getErc20Address() {
        return this.erc20Address;
    }

    public void setErc20Address(String erc20Address) {
        this.erc20Address = erc20Address;
    }

    public String getMyPrivateKey() {
        return this.myPrivateKey;
    }

    public void setMyPrivateKey(String myPrivateKey) {
        this.myPrivateKey = myPrivateKey;
    }

    public String getMyAddress() {
        return this.myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    public String getOtherAddress() {
        return this.otherAddress;
    }

    public void setOtherAddress(String otherAddress) {
        this.otherAddress = otherAddress;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    /*
     * Request construct for transfer
     */
    public MyERC20Request(String erc20Address, String myPrivateKey, String myAddress, String otherAddress, String amount) {
        this.erc20Address = erc20Address;
        this.myPrivateKey = myPrivateKey;
        this.myAddress = myAddress;
        this.otherAddress = otherAddress;
        this.amount = amount;
    }
    
    /*
     * Request construct for get balance
     */
    public MyERC20Request(String erc20Address, String myPrivateKey) {
        this.erc20Address = erc20Address;
        this.myPrivateKey = myPrivateKey;
    }
    
    
}
