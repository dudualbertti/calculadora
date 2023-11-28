package com.api.celcoin.service;

import com.api.celcoin.domain.dto.PixDTO;
import com.api.celcoin.domain.repositories.IPixDatabaseRepository;
import com.api.celcoin.domain.usecases.CreatePixQRCode;
import com.api.celcoin.infra.celcoin.repository.PixCelcoinRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PixService {

    @Inject
    PixCelcoinRepository pixCelcoinRepository;

    @Inject
    IPixDatabaseRepository pixDatabaseRepository;

    @Transactional
    public Response handlePix(PixDTO dto) {
        CreatePixQRCode createPix = new CreatePixQRCode(pixCelcoinRepository, pixDatabaseRepository);

        PixDTO createdPix = createPix.execute(dto);

        return Response.ok(createdPix).build();
    }
}
