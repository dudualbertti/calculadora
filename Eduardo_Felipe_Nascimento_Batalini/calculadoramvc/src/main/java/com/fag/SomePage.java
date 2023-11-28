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
public class SomePage {

    private final Template page;
    private final Template resultado;
    List<String> operadores = List.of(" Soma", "Subtração" , "Multiplicação" , "Divisão");

    public SomePage(Template page, Template resultado) {
        this.page = requireNonNull(page, "page is required");
        this.resultado = requireNonNull(resultado, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        
        return page.data("operadores", operadores);
    }

    @POST
    @Path("/resultado")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@FormParam("valor1")Double valor1,@FormParam("valor2") Double valor2, @FormParam("operacao") String operacao) {
        
        Double result = 0.0;

        switch(operacao){
            case "som":
                result = valor1 + valor2;
                break;

            case "sub":
            result = valor1 - valor2;
                break;

            case "mult":
            result = valor1 * valor2;
                break;

            case "div":
            if(valor2 != 0){
                result = valor1 / valor2;
            }else{
                throw new RuntimeException("O segundo valor não pode ser 0");
            }
                break;


            }
            System.out.println(operacao);
        
        return resultado.data("resultado", result)
        .data("operadores", operadores);

    }
}
