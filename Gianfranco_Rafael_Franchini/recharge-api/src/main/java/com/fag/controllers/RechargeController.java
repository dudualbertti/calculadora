package com.fag.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(("/recharge"))
public class RechargeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recharge() {
        return null;
    }

}
