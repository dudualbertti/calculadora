package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.ProviderDTO;
import com.fag.infra.celcoin.dto.CelcoinProviderDTO;

public class CelcoinProviderMapper {
    
    public static ProviderDTO toAppDTO(CelcoinProviderDTO vendorDTO) {
        ProviderDTO appDTO = new ProviderDTO();

        appDTO.setCategory(vendorDTO.getCategory());
        appDTO.setMaxValue(vendorDTO.getMaxValue());
        appDTO.setMinValue(vendorDTO.getMinValue());
        appDTO.setName(vendorDTO.getName());
        appDTO.setProviderID(vendorDTO.getProviderId());

        return appDTO;
    }

}
