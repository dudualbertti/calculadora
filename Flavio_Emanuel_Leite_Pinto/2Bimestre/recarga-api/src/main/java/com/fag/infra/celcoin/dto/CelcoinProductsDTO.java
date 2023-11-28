package com.fag.infra.celcoin.dto;
import java.util.List;

public class CelcoinProductsDTO {
    private List<CelcoinProductsDTO> products;

    public List<CelcoinProductsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<CelcoinProductsDTO> products) {
        this.products = products;
    }

}
