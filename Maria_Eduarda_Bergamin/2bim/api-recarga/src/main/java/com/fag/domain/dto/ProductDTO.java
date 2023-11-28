package com.fag.domain.dto;

public class ProductDTO {
    private String name;
    private Integer due;
    private Double value;

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public Integer getDue() {
        return due;
    }

    public void setDue(Integer dueProduct) {
        this.due = dueProduct;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
