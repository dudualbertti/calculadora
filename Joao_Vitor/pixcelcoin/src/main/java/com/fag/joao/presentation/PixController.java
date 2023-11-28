package com.fag.joao.presentation;

import com.fag.joao.domain.usecases.IMakePixRequest;
import com.fag.joao.services.MakePix;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class PixController {

    @Inject
    MakePix service;

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String handle(
        @HeaderParam("pixKey") String pixKey,
        @HeaderParam("value") Double value
    ) {
        return service.getQrCode(new IMakePixRequest(pixKey, value));
    }
}
