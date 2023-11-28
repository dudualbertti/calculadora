package com.fag.infra.celcoin.mappers;
import com.fag.domain.dto.OperatorDTO;

public class CelcoinOperatorMapper {
    public static OperatorDTO toAppDto(CelcoinOperatorDTO vendorDTO) {
        OperatorDTO appDTO = new OperatorDTO();
        appDTO.setCategory(vendorDTO.getCategoty());
        appDTO.setMaxValue(vendorDTO.getMaxValue());
        appDTO.setMinValue(vendorDTO.getMinValue());
        appDTO.setName(vendorDTO.getName());
        appDTO.setProviderID(vendorDTO.getProviderID());
        appDTO.setRechargeType(vendorDTO.getRechargeType());
        return appDTO;
    
    }
}
