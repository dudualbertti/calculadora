package br.fag.controller;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Path("/calc")
public class SomePage {

    private final Template page;

    private final Template calc;

    public SomePage(Template page, Template calc) {
        this.page = requireNonNull(page, "page is required");
        this.calc = requireNonNull(calc, "Page is required");
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

        return calc.data("result", result);
    }


}