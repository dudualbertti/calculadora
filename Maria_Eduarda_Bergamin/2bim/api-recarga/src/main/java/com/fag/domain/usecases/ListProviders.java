package com.fag.domain.usecases;

import com.fag.domain.repositories.IRechargeVendor;

import java.util.List;

import com.fag.domain.dto.ProviderDTO;

public class ListProviders {
    
    private IRechargeVendor vendor;

    public ListProviders(IRechargeVendor vendor) {
        this.vendor = vendor;
    }

    public List<ProviderDTO> execute(Integer stateCode, Integer category){
        
        return vendor.listProviders(stateCode, category);
    }
}