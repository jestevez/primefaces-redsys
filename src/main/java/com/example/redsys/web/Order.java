package com.example.redsys.web;

import java.io.Serializable;
import java.util.Random;

public class Order implements Serializable {

    private String id;
    private double amount;
    private String number;
    private String description;

    // datos del request
    private String signatureVersion;
    private String merchantParamenters;
    private String signature;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
