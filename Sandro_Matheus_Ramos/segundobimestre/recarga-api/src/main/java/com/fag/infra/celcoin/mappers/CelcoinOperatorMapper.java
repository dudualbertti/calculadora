package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.ProviderDTO;
import com.fag.infra.celcoin.dto.CelcoinOperatorDTO;

public class CelcoinOperatorMapper {

    public static ProviderDTO toAppDTO(CelcoinOperatorDTO vendorDTO) {
        ProviderDTO appDTO = new ProviderDTO();

        appDTO.setCategory(vendorDTO.getCategory());
        appDTO.setMaxValue(vendorDTO.getMaxValue());
        appDTO.setMinValue(vendorDTO.getMinValue());
        appDTO.setName(vendorDTO.getName());
        appDTO.setOperatorId(vendorDTO.getProviderId());

        return appDTO;
    }

}
