package br.fag;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@Path("/calc")
public class CalcController {

    private final Template page;
    private final Template resultado;

    public CalcController(Template page, Template resultado) {
        this.page = requireNonNull(page, "page is required");
        this.resultado = requireNonNull(resultado, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        return page.data("name", name);
    }

    @POST
    @Path("/resultado")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@FormParam("valor1") Double valor1, @FormParam("valor2") Double valor2, @FormParam("operador") String operador){
        double result = 0.0;
    switch (operador){
        case "+":
            result = valor1+valor2;
            break;
        case "-":
            result =  valor1-valor2;
            break;
        case "*":
            result = valor1*valor2;
            break;
        case "/":
            if(valor2!=0) {
                result = valor1 / valor2;
            }
    }
    return resultado.data("resultado", result);
    }


}
