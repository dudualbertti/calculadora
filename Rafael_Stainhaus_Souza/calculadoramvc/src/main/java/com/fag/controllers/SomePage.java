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

@Path("/calculo")
public class SomePage {

    private final Template page;
    private final Template result;

    public SomePage(Template page, Template result) {
        this.page = requireNonNull(page, "page is required");
        this.result = requireNonNull(result, "result is required");
    }
                            
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        return page.data("name", name);
    }

    @POST
    @Path("/calcular")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@FormParam("valor1") Double valor1,@FormParam("valor2") Double valor2,@FormParam("op") String operador) {
        
        Double resultado = 0d;

        switch (operador) {
            case "Soma":
                resultado = valor1 + valor2;
                break;
            case "Sub":
                resultado = valor1 - valor2;
                break;
            case "Mult":
                resultado = valor1 * valor2;
                break;
            case "Div":
            if(valor2 != 0){
                resultado = valor1 / valor2;
                break;
            }else{
                throw new RuntimeException("ERRO,O SEGUNDO VALOR TEM QUE SER DIFERENTE DE ZERO(0)!");
            }
            default:
                break;
        }
        
        
        return result.data("name", resultado);
    }

   



}
