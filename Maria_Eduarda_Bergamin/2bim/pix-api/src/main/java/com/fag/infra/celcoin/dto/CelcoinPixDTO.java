package com.fag.infra.celcoin.dto;

import java.math.BigDecimal;

public class CelcoinPixDTO {
    
    private CelcoinPixMerchantDTO merchant;
    private String key;
    private BigDecimal amount;
    private Object pixDTO;

    public CelcoinPixMerchantDTO getMerchant() {
        return merchant;
    }
    public void setMerchant(CelcoinPixMerchantDTO merchant) {
        this.merchant = merchant;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Object getPixDTO() {
        return pixDTO;
    }
    public void setPixDTO(Object pixDTO) {
        this.pixDTO = pixDTO;
    }
   
    

    
}
