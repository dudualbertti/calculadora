package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.PhoneDTO;
import com.fag.infra.celcoin.dto.CelcoinPhoneDTO;

public class CelcoinRechargePhoneMapper {
    public static PhoneDTO toAppDTO(CelcoinPhoneDTO vendorDTO) {
        PhoneDTO AppDTO = new PhoneDTO();
        AppDTO.setStateCode(vendorDTO.getStateCode());
        AppDTO.setCountryCode(vendorDTO.getCountryCode());
        AppDTO.setNumber(vendorDTO.getNumber());
        return AppDTO;
         
    }

    public static CelcoinPhoneDTO toVendorDTO(PhoneDTO appDTO) {
        CelcoinPhoneDTO vendorDTO = new CelcoinPhoneDTO();
        vendorDTO.setStateCode(appDTO.getStateCode());
        vendorDTO.setCountryCode(appDTO.getCountryCode());
        vendorDTO.setNumber(appDTO.getNumber());
        return vendorDTO;
        
    }
}
