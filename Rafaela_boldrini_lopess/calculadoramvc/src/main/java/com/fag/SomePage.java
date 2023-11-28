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

@Path("/some-page")

public class SomePage {

    private final Template page;
    private final Template result;

    public SomePage(Template page, Template result) {
        this.page = requireNonNull(page, "page is required");
        this.result = requireNonNull(result, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        return page.data("name");

    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance result(
            @FormParam("val1") double val1,
            @FormParam("val2") double val2,
            @FormParam("operation") String operation) {

        double result2 = 0;

        switch (operation) {
            case "soma":
                result2 = val1 + val2;
                break;
            case "sub":
                result2 = val1 - val2;
                break;
            case "multi":
                result2 = val1 * val2;
                break;
            case "divide":

                if (val2 != 0) {
                    result2 = val1 / val2;
                } else {

                    result2 = Double.NaN;
                }
                break;
            default:
                break;
        }

        return result.data("result", result2)
                .data("val1", val1)
                .data("val2", val2)
                .data("operation", operation);

    }
}