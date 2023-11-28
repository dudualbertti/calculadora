package com.fag.controllers;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import javax.management.RuntimeErrorException;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;

@Path("/calculator")
public class SomePage {

    private final Template page;

    private final Template calculator;

    public SomePage(Template page, Template calculator) {
        this.page = requireNonNull(page, "page is required");
        this.calculator = requireNonNull(calculator, "Page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        List<String> operadores = List.of("Soma", "Subtração", "Multiplicação", "Divisão");
        return page.data("operadores", operadores);
    }

    @POST
    @Path("/result")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calculate(@FormParam("val1") Double val1, @FormParam("val2") Double val2, @FormParam("option") String operador) {
        
        Double result = 0.0;
        switch(operador){
            case "Soma":
                result = val1 + val2;
                break;
            case "Subtração":
                result = val1 - val2;
                break;
            case "Multiplicação":
                result = val1 * val2;
                break;
            case "Divisão":

                if (val2 == 0) {
                    throw new RuntimeException("[ERRO] Segundo valor invalido!");
                }else{
                    result = val1 / val2;
                }
                break;
        }
        
        System.out.println(operador);

        return calculator.data("result", result);
    }


}
