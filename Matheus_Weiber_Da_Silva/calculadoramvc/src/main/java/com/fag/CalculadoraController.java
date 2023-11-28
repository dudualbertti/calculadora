package com.fag;

import static java.util.Objects.requireNonNull;

import java.util.List;

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
    List<String> operadores = List.of("+", "-", "*", "/");

    public CalculadoraController(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        return page.data("operadores", operadores).data("result", null);
    }

    @POST
    public TemplateInstance calcular(@FormParam("valor1") Double valor1,
            @FormParam("valor2") Double valor2, @FormParam("operador") String operador) {
       
                double result = 0d;
                switch (operador) {
                    case "+":
                        result= valor1+valor2;
                        break;
                     case "-":
                        result= valor1-valor2;
                        break;
                         case "*":
                        result= valor1*valor2;
                        break;
                         case "/":
                        result= valor1/valor2;
                        break;
                    default:
                        break;
                }
        
        return page.data("result", result).data("operadores", operadores);
    }
}
