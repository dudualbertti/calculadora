package org.fag;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@Path("/some-page")
public class SomePage {

    private final Template page;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calcular(
        @FormParam("num1") int num1, 
        @FormParam("num2") int num2, 
        @FormParam("operador") String operador
    ) {
        double resultado = 0.0;       

        if ("somar".equals(operador)) {
            resultado = num1 + num2;
        } else if ("subtrair".equals(operador)) {
            resultado = num1 - num2;
        } else if ("multiplicar".equals(operador)) {
            resultado = num1 * num2;
        } else if ("dividir".equals(operador)) {
            if (num2 != 0) {
                resultado = (double) num1 / num2;
            } else {
                throw new ArithmeticException("Divisão por zero.");
            }
        }
        
        return page.data("name", String.valueOf(resultado));
    }
}