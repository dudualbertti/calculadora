package com.fag.domain.usecases;

import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.repositories.IRechargeVendor;

public class CreateRecharge {
    private IRechargeVendor repo;

    CreateRecharge(IRechargeVendor repo) {
        this.repo = repo;
    

    }
    public RechargeDTO execute(RechargeDTO dto){
        return repo.createRecharge(dto);
    }
}
