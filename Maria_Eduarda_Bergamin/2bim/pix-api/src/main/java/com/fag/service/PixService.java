package com.fag.service;
import com.fag.domain.dto.PixDTO;
import com.fag.domain.usecases.CreatePix;
import com.fag.infra.celcoin.repository.CelcoinPixRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixService {
    
    @Inject
    CelcoinPixRepository celcoinPixRepository;

    public PixDTO genPix(PixDTO dto) {

        CreatePix createPix = new CreatePix(celcoinPixRepository);

        return createPix.execute(dto);
    }

}


