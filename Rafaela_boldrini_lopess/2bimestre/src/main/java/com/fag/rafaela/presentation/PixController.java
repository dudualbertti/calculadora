package com.fag.rafaela.presentation;


import com.fag.rafaela.domain.usecases.IPixRequest;
import com.fag.rafaela.features.MakePix;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/rafaela")
public class PixController {

    @Inject
    MakePix service;

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String handle(
        @HeaderParam("pixCode") String pixCode,
        @HeaderParam("value") Double value
    ) {
        System.out.println("value is " + value);
        System.out.println("pixCode is " + pixCode);
        return service.exec(new IPixRequest(pixCode, value));
    }
}
