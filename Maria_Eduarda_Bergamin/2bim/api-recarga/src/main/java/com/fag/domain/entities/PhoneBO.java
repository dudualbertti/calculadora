package com.fag.domain.entities;

public class PhoneBO {
    private String stateCode;
    private String countryCode;
    private String number;

    public PhoneBO(String stateCode, String countryCode, String number) {
        this.stateCode = stateCode;
        this.countryCode = countryCode;
        this.number = number;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
