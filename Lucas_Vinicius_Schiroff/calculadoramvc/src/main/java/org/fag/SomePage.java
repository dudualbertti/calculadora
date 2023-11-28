package org.fag;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

@Path("/some-page")
public class SomePage {

    private final Template page;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        return page.data("name", "0");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calcular(@FormParam("valor1") Double valor1,
    @FormParam("valor2") Double valor2,
    @FormParam("operacao")String operacao) {

        double resultado = 0.0;

        if(operacao != null){
            switch (operacao) {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "*":
                    resultado = valor1 * valor2;
                    break;
                case "/":
                    resultado = valor1 / valor2;
                    break;
            }
        }

        return page.data("name", resultado);
        
    }
    

}
