package com.fag.domain.dto;

public class RechargeDTO {

    private double value;

    private String document;

    private Integer providerId;

    private PhoneDTO phone;

    public void setValue(double value) {
        this.value = value;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public void setPhone(PhoneDTO phone) {
        this.phone = phone;
    }

    public double getValue() {
        return value;
    }

    public String getDocument() {
        return document;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public PhoneDTO getPhone() {
        return phone;
    }

    public void setReceipt(String receiptData) {
    }

    public void setTransactionId(long transactionId) {
    }

    public void setSuccess(boolean equals) {
    }

}
