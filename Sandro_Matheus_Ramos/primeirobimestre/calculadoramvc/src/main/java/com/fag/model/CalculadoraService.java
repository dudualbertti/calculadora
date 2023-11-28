package com.fag.model;

public class CalculadoraService {

    public Double realizarCalculo(Double valor1, Double valor2, String operacao) {
        Double resultado = 0d;

        switch (operacao) {
            case "Soma":
                resultado = valor1 + valor2;
                break;
            case "Sub":
                resultado = valor1 - valor2;
                break;
            case "Mult":
                resultado = valor1 * valor2;
                break;
            case "Div":
                resultado = valor1 / valor2;
                break;
            default:
                break;
        }

        return resultado;
    }

}
