package com.fag.controllers;

import static java.util.Objects.requireNonNull;

import com.fag.model.CalculadoraService;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/calculadora")
public class CalculadoraController {

    private final Template page;

    public CalculadoraController(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("name", null);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(
            @FormParam("valor1") Double valor1,
            @FormParam("valor2") Double valor2,
            @FormParam("operacao") String operacao) {
        CalculadoraService service = new CalculadoraService();

        return page.data("resultado", service.realizarCalculo(valor1, valor2, operacao));
    }
}
