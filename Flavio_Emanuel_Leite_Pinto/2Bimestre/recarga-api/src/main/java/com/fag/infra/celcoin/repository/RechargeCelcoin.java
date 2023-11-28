package com.fag.infra.celcoin.repository;

import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.repositories.IRechargeVendor;
import com.fag.infra.celcoin.dto.CelcoinOperatorsDTO;
import com.fag.infra.celcoin.dto.CelcoinRechargeDTO;
import com.fag.infra.celcoin.dto.CelcoinRechargeResponseDTO;
import com.fag.infra.celcoin.mappers.CelcoinOperatorMapper;
import com.fag.infra.celcoin.mappers.CelcoinRechargeMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RechargeCelcoin implements IRechargeVendor {

@Inject

@RestClient RestClient;

@Override

public RechargeDTO create(RechargeDTO recharge){
    try{
        CelcoinRechargeDTO RechargeDTO = CelcoinRechargeMapper.toVendorDTO(recharge);

        CelcoinRechargeResponseDTO response = RestClient.handleRecharge(getToken(), rechargeDTO);

        recharge.setReceipt(response.getReceipt().getReceiptData());

         recharge.setTransactionId(response.getTransactionId());

          recharge.setSuccess(response.getErrorCode().equals("000"));

    }
    catch (Exception e){

        throw new RuntimeException("Erro comunicação com o provedor do serviço de recarga");

    }

    return recharge

}



    @Override

    public List<OperatorsDTO> ListOperators(Integer stateCode, Integer category) {

        try {

            CelcoinOperatorsDTO = restClient.ListOperators(getToken(), stateCode, category);

            return operators.getProviders().stream().map(operator > CelcoinOperatorMapper.toAppDTO(operator))
                    .collect(Collectors.toList());
        }

        catch (Exception e) {

            throw new RuntimeException("Erro comunicação provedor servico recarga", e);

        }

    }

    @Override
    public List<ProducDTO> listProducts(Integer operatorId, Integer stateCode) {
        try {
            CelcoinProductsDTO Products = restClient.listProducts(getToken(), stateCode, operatorId);

            return Products.getProducts().stream().map(Products > CelcoinProductMapper.toAppDTO(Products))
                    .collect(Collectors.toList());

        }

        catch (Exception e) {

            throw new RuntimeException("Erro comunicação provedor servico recarga", e);

        }
    }

private String getToken(){

    Form form = new Form();

    form.param("client_id", "41b44ab9a56440.test.celcoinapi.v5");
    form.param("grant_type","client_credentials");
    form.param("client_secret","e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");
    CelcoinTokenDTO tokenDTO = restClient.generateToken(form);
    String token = "Bearer" + tokenDTO.getAccessToken();
    
    return token


}
}