package com.api.celcoin.domain.usecases;


import com.api.celcoin.domain.dto.PixDTO;
import com.api.celcoin.domain.entities.PixBO;
import com.api.celcoin.domain.mappers.PixMapper;
import com.api.celcoin.domain.repositories.IPixDatabaseRepository;
import com.api.celcoin.domain.repositories.IPixVendorRepository;

public class CreatePixQRCode {

    private IPixVendorRepository vendor;
    private IPixDatabaseRepository repository;

    public CreatePixQRCode(IPixVendorRepository vendor, IPixDatabaseRepository repository) {
        this.vendor = vendor;
        this.repository = repository;
    }

    public PixDTO execute(PixDTO dto) {
        PixDTO response = vendor.create(dto);
        PixBO bo = PixMapper.toBO(response);

        repository.persist(bo);

        return response;
    }


}
