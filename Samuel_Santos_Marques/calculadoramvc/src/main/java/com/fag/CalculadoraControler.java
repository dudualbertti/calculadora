package com.fag;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

import java.util.List;

@Path("/calculadora")
public class CalculadoraControler {

    private final Template page;
    private final Template calcular;

    public CalculadoraControler(Template page, Template calcular) {
        this.page = requireNonNull(page, "page is required");
        this.calcular = requireNonNull(calcular, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        List<String> operacao = List.of("+","-","*","/");
        return page.data("operacao", operacao);
    }

    @POST
    @Path("/resultado")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@FormParam("valor01") Double valor1, @FormParam("valor02") Double valor2,
            @FormParam("operacao") String operacao) {
        Double resultado = 8.0;

        switch (operacao) {
            case "Adicao":
            resultado = valor1 + valor2;
                break;
            case "Subtracao":
            resultado = valor1 - valor2;
                break;
            case "Multiplicacao":
            resultado = valor1 * valor2;
                break;
            case "Divisao":
            resultado = valor1 / valor2;
                break;

        }

        return calcular.data("resultado", resultado);
    }

}
