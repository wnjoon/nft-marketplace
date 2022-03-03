package com.exercise.request;

public class MyERC721Request {
    
    private String erc721Address;
    private String myPrivateKey;
    private String myAddress;
    private String otherAddress;
    private int tokenId;
    private String url;

    public String getErc721Address() {
        return this.erc721Address;
    }

    public void setErc721Address(String erc721Address) {
        this.erc721Address = erc721Address;
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

    public int getTokenId() {
        return this.tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*
     * Request construct for mint
     */
    public MyERC721Request(String erc721Address, String myAddress, String myPrivateKey, String url) {
        this.erc721Address = erc721Address;
        this.myAddress = myAddress;
        this.myPrivateKey = myPrivateKey;
        this.url = url;
    }

    /*
     * Request construct for get balance (amount of tokens)
     */
    public MyERC721Request(String erc721Address, String myAddress, String myPrivateKey) {
        this.erc721Address = erc721Address;
        this.myAddress = myAddress;
        this.myPrivateKey = myPrivateKey;
    }

    /*
     * Request construct for transferFrom
     */
    public MyERC721Request(String erc721Address, String myPrivateKey, String myAddress, String otherAddress, int tokenId) {
        this.erc721Address = erc721Address;
        this.myPrivateKey = myPrivateKey;
        this.myAddress = myAddress;
        this.otherAddress = otherAddress;
        this.tokenId = tokenId;
    }
}
