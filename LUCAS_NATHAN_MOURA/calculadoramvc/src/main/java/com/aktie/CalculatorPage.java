package com.aktie;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.text.DecimalFormat;

import static java.util.Objects.requireNonNull;

@Path("/calculator")
public class CalculatorPage {

    private final Template page;
    private double result = 0;

    public CalculatorPage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("result", formatResult(result));
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calculate(
        @FormParam("number1") String number1Str,
        @FormParam("number2") String number2Str,
        @FormParam("operation") String operation) {

        double number1;
        double number2;

        try {
            number1 = Double.parseDouble(number1Str.replace(",", "."));
            number2 = Double.parseDouble(number2Str.replace(",", "."));

            switch (operation) {
                case "add":
                    result = number1 + number2;
                    break;
                case "subtract":
                    result = number1 - number2;
                    break;
                case "multiply":
                    result = number1 * number2;
                    break;
                case "divide":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        return page.data("result", "Erro: Divisão por zero!");
                    }
                    break;
                default:
                    return page.data("result", "Operação inválida");
            }
        } catch (NumberFormatException e) {
            return page.data("result", "Erro: Entrada inválida");
        }

        return page.data("result", formatResult(result));
    }

    private String formatResult(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(result);
    }
}
