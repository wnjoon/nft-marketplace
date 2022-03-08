package com.exercise.marketplace.token.request;

public class MyERC721Request {
    
    private String myId;
    private String receiverId;
    private String tokenId;
    private String url;

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

	public String getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    public MyERC721Request() {}

    public MyERC721Request(String myId, String receiverId, String tokenId, String url) {
        this.myId = myId;
        this.receiverId = receiverId;
        this.tokenId = tokenId;
        this.url = url;
    }

    /*
     * Request construct for transfer
     */
    public MyERC721Request(String myId, String receiverId, String tokenId) {
        this.myId = myId;
        this.receiverId = receiverId;
        this.tokenId = tokenId;
    }

    /*
     * Request construct for get tokens of user
     */
    public MyERC721Request(String myId) {
        this.myId = myId;
    }

    /*
     * Request construct for mint
     */
    public MyERC721Request(String myId, String url) {
        this.myId = myId;
        this.url = url;
    }
}
