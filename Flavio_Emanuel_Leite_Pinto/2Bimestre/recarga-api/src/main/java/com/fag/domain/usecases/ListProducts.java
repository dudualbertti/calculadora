package com.fag.domain.usecases;

import com.fag.domain.dto.ProductDTO;
import com.fag.domain.repositories.IRechargeVendor;
import java.util.List;

public class ListProducts {

    private IRechargeVendor repo;

    ListProducts(IRechargeVendor repo) {
        this.repo = repo;
    }

    public List<ProductDTO> execute(Integer providerID) {

        return repo.Listproduct(providerID);
    }
}
