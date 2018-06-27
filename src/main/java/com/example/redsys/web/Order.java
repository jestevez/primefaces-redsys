package com.example.redsys.web;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Order implements Serializable {

    private Date date;
    private double amount;
    private String number;
    private String description;

    // datos del request
    private String signatureVersion;
    private String merchantParamenters;
    private String signature;

    // datos de la respuesta
    private String signatureVersionReceived;
    private String merchantParamentersReceived;
    private String signatureReceived;

    // datos del pago
    private String authorisationCode;
    private String dateReceived;
    private String hourReceived;
    private String response;

    private String status;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSignatureVersion() {
        return signatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {
        this.signatureVersion = signatureVersion;
    }

    public String getMerchantParamenters() {
        return merchantParamenters;
    }

    public void setMerchantParamenters(String merchantParamenters) {
        this.merchantParamenters = merchantParamenters;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignatureVersionReceived() {
        return signatureVersionReceived;
    }

    public void setSignatureVersionReceived(String signatureVersionReceived) {
        this.signatureVersionReceived = signatureVersionReceived;
    }

    public String getMerchantParamentersReceived() {
        return merchantParamentersReceived;
    }

    public void setMerchantParamentersReceived(String merchantParamentersReceived) {
        this.merchantParamentersReceived = merchantParamentersReceived;
    }

    public String getSignatureReceived() {
        return signatureReceived;
    }

    public void setSignatureReceived(String signatureReceived) {
        this.signatureReceived = signatureReceived;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getHourReceived() {
        return hourReceived;
    }

    public void setHourReceived(String hourReceived) {
        this.hourReceived = hourReceived;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String getRandomOrderNumber() {

        char[] chars = "0123456789".toCharArray(); //ABCDEFGHIJKLMNOPQRSTUVWXYZ
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++) {
            sb.append(chars[rnd.nextInt(chars.length)]);
        }

        return sb.toString();
    }
}
