package com.fag.lucas.presentation;

import com.fag.lucas.data.MakePix;
import com.fag.lucas.domain.usecases.IMakePixRequest;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pix")
public class Controller {

    @Inject
    MakePix service;

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String handle(
        @HeaderParam("key") String key,
        @HeaderParam("value") Double value
    ) {
        return service.getQrCode(new IMakePixRequest(key, value));
    }
}
