package com.fag.domain.repositories;
import com.fag.domain.dto.OperatorDTO;
import com.fag.domain.dto.ProductDTO;
import com.fag.domain.dto.RechargeDTO;

import java.util.List;
public interface IRechargeVendor {

    List<OperatorDTO> listOperator();
    List<ProductDTO> Listproduct(Integer providerID);
    RechargeDTO createRecharge(RechargeDTO dto);
}
