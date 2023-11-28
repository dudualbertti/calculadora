package com.fag.controller;
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

@Path("/some-page")
public class CalculadoraController {

    private final Template page;

    public CalculadoraController(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces (MediaType.TEXT_HTML)
    public TemplateInstance get(){
        return page.data("result", 0d);
    }

    @POST
    @Produces(MediaType.TEXT_HTML) 
    public TemplateInstance get(
        @FormParam("numero1") Double num1,
        @FormParam("numero2") Double num2,
        @FormParam("operation") String operation) {
        
            Double resultado = (double) 0;

            switch(operation) {
                case "Soma":
                    resultado = num1 + num2;
                    break;
                case "Divisão":
                    if(num2 != 0){
                        resultado = num1 / num2;
                    }
                    else {
                        resultado = Double.NaN; 
                    }
                    break;
                case "Multiplicação":
                    resultado = num1 * num2;
                    break;
                case "Subtração":
                    resultado = num1 - num2;
                    break;
                default:
                    break;
            }

        return page.data("result", resultado);
    }

    


}
