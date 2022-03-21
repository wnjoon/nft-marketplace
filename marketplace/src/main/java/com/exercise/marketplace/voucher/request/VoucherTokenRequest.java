package com.exercise.marketplace.voucher.request;

public class VoucherTokenRequest {
 
    private String myId;
    private String artworkName;
    private String artworkId;
    private String startDate;
    private String endDate;

    public VoucherTokenRequest() {}
    
    public VoucherTokenRequest(String myId, String artworkName, String artworkId, String startDate, String endDate) {
        this.myId = myId;
        this.artworkName = artworkName;
        this.artworkId = artworkId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMyId() {
        return this.myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }
    
    public String getArtworkName() {
        return this.artworkName;
    }

    public void setArtworkName(String artworkName) {
        this.artworkName = artworkName;
    }

    public String getArtworkId() {
        return this.artworkId;
    }

    public void setArtworkId(String artworkId) {
        this.artworkId = artworkId;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
