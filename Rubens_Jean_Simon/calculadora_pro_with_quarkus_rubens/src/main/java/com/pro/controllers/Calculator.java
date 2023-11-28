package com.pro.controllers;

import com.pro.model.ChoiceUser;
import com.pro.services.CalculatorService;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.TEXT_HTML)
@Produces(MediaType.TEXT_HTML)
@Path("/")
public class Calculator {

    @Inject
    Template page;

    @Inject
    Template calculator;

    @GET
    public TemplateInstance get() {
        var arithmeticOperations = Arrays.asList(ChoiceUser.values())
                .stream()
                .map(ChoiceUser::getOption)
                .collect(Collectors.toList());

        return page.data("name", "PRO", "arithmeticOperations", arithmeticOperations);
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public TemplateInstance post(@FormParam("primeiroValor") Float valueOne, @FormParam("segundoValor") Float valueTwo,
            @FormParam("selectCalculadora") Integer operation) {

        CalculatorService service = new CalculatorService();

        Float result = service.calculate(valueOne, valueTwo, operation);

        return calculator.data("name", "Resultado", "result", result);

    }

}