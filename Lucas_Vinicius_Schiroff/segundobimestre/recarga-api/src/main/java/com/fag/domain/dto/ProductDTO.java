package com.fag.domain.dto;

public class ProductDTO {

    private Integer due;

    private String name;

    private Double value;

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getDue() {
        return due;
    }

    public void setDue(Integer dueProduct) {
        this.due = dueProduct;
    }

}
