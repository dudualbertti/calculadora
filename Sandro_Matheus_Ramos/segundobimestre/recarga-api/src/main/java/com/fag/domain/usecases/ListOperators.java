package com.fag.domain.usecases;

import java.util.List;

import com.fag.domain.dto.ProviderDTO;
import com.fag.domain.repositories.IRechargeVendor;

public class ListOperators {

    private IRechargeVendor vendor;

    public ListOperators(IRechargeVendor vendor) {
        this.vendor = vendor;
    }

    public List<ProviderDTO> execute(Integer stateCode, Integer category) {
        return vendor.listOperators(stateCode, category);
    }

}
