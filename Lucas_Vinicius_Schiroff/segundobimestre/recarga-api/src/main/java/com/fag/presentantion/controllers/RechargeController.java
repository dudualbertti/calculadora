package com.fag.presentantion.controllers;

import com.fag.service.RechargeService;
import jakarta.Inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/recharge")
public class RechargeController {

    @Inject
    RechargeService service;

    @GET
    @Path("/operators")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return service.listOperators(45, 0);
    }
}
