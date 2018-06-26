package com.example.redsys.web;

public class TransactionDeclinedException extends Exception {

    private int responseCode;
    private String responseMessage;

    public TransactionDeclinedException() {
    }

    public TransactionDeclinedException(int responseCode, String responseMessage) {
        super(responseCode + " - " + responseMessage);
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public TransactionDeclinedException(String message) {
        super(message);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
