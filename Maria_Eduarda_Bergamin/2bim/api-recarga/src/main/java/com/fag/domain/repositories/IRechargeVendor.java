package com.fag.domain.repositories;

import com.fag.domain.dto.ProviderDTO;
import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.dto.ProductDTO;
import java.util.List;

//funcionalidades celcoin
public interface IRechargeVendor {
    //responsavel por listar operadoras
    List <ProviderDTO> listProviders(Integer stateCode, Integer category);

    //responsavel por listar os produtos a partir do id da operadora
    List<ProductDTO> listProducts(Integer stateCode, Integer providerID);

    RechargeDTO create(RechargeDTO recharge);
    

}
