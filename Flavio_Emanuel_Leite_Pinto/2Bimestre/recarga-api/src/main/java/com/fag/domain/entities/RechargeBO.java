package com.fag.domain.entities;

public class RechargeBO {

    private double value;

    private String document;

    private Integer providerId;

    private PhoneBO phone;

    public RechargeBO(double value, String document, Integer providerId, PhoneBO phone) {
        this.value = value;
        this.document = document;
        this.providerId = providerId;
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

    public PhoneBO getPhone() {
        return phone;
    }

    
}