package com.fag.lucas.presentation;

import com.fag.lucas.data.Pix;
import com.fag.lucas.domain.usecases.IPixServiceRequest;

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
    Pix service;

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String handle(
        @HeaderParam("pix") String pix,
        @HeaderParam("value") Double value
    ) {
        System.out.println("value is " + value);
        System.out.println("pix is " + pix);
        return service.perform(new IPixServiceRequest(pix, value));
    }
}
