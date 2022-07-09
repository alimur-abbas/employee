package com.example.SpringBootWebApi.Model;

public class MessageModel {
    private String mobileNumber;
    private String smsText;

    public MessageModel() {
        super();
    }


    public MessageModel(String mobileNumber, String smsText) {
        this.mobileNumber = mobileNumber;
        this.smsText = smsText;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }
}
