package com.fag.infra.celcoin.repository;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.repositories.IPixRepository;
import com.fag.infra.celcoin.dto.CelcoinPixDTO;
import com.fag.infra.celcoin.dto.CelcoinPixMerchantDTO;
import com.fag.infra.celcoin.dto.CelcoinPixResponse;
import com.fag.infra.celcoin.dto.CelcoinTokenDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;

@ApplicationScoped
public class CelcoinPixRepository implements IPixRepository {

    @Inject
    @RestClient
    RestClientCelcoin restClient;

    @Override
    public PixDTO create(PixDTO dto) {
        
        CelcoinPixDTO celcoinDTO = new CelcoinPixDTO();
        celcoinDTO.setAmount(dto.getAmount());
        celcoinDTO.setKey("testepix@celcoin.com.br");

        CelcoinPixMerchantDTO merchantDTO = new CelcoinPixMerchantDTO();
        merchantDTO.setCity(dto.getMerchant().getCity());
        merchantDTO.setMerchantCategoryCode(dto.getMerchant().getMerchantCategoryCode());
        merchantDTO.setName(dto.getMerchant().getName());
        merchantDTO.setPostalCode(dto.getMerchant().getPostalCode());

        celcoinDTO.setMerchant(merchantDTO);

        CelcoinPixResponse response = restClient.handlePix(getToken(), celcoinDTO);

        dto.setEmv(response.getEmvqrcps());

        return dto;
    }
    
     private String getToken() {
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        CelcoinTokenDTO tokenDTO = restClient.generateToken(form);
        String token = "Bearer " + tokenDTO.getAccessToken();
            
        return token;
    }
}
