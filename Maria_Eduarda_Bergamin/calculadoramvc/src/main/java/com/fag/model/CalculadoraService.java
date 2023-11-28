package com.fag.model;

import com.fag.controllers.PageController;

public class CalculadoraService {
    public Double realizarCalculo(Double valor1, Double valor2, String operacao) {
        Double resultado = 0d;
        String mensagem;

        switch (operacao) {
            case "Soma":
                resultado = valor1 + valor2;
                break;
            case "Subtraçao":
                resultado = valor1 - valor2;
                break;
            case "Multiplicaçao":
                resultado = valor1 * valor2;
                break;
            case "Divisao":
                if (valor2 == 0) {
                    return null;
                }
                resultado = valor1 / valor2;
                break;
            default:
                break;
        }
        return resultado;
    }
}
