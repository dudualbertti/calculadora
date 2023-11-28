package com.fag.domain.mappers;

import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.entities.RechargeBO;

public class RechargeMapper {

    public static RechargeDTO toDTO(RechargeBO bo) {
        RechargeDTO dto = new RechargeDTO();

        dto.setValue(bo.getValue());
        dto.setDocument(bo.getDocument());
        dto.setProviderId(bo.getProviderId());
        dto.setPhone(PhoneMapper.toDTO(bo.getPhone()));
        return dto;
    }

    public static RechargeBO toBO(RechargeDTO dto) {

        return new RechargeBO(
            dto.getValue(),
            dto.getDocument(),
            dto.getProviderId(),
            PhoneMapper.toBO(dto.getPhone()));
        
    }
 }
