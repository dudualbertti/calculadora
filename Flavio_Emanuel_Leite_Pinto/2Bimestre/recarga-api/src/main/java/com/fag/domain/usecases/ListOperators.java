package com.fag.domain.usecases;

import com.fag.domain.dto.OperatorDTO;
import com.fag.domain.repositories.IRechargeVendor;
import java.util.List;
public class ListOperators {
    private IRechargeVendor repo;
    
    ListOperators(IRechargeVendor repo){
        this.repo = repo;
    }
    public List<OperatorDTO> execute() {
        return repo.listOperator();
    }
}
