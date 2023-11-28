package com.fag.infra.celcoin.mappers;
import com.fag.domain.dto.ProductDTO;

public class CelcoinProductMapper {
    public static ProductDTO toAppDto(CelcoinProductDTO vendorDTO) {
        ProductDTO appDTO = new ProductDTO();

        appDTO.setcode(vendorDTO.getCode());
        appDTO.setCost(vendorDTO.getCost());
        appDTO.setName(vendorDTO.getProductName());
        appDTO.setValue(vendorDTO.getMinValue());
        appDTO.setDueProduct(vendorDTO.getDueProduct());
        return appDTO;

    }
}
