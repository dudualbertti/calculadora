package main.model;
import java.util.Scanner;


public class CalculadoraService {
//criar método vai receber tres valores e retornar double - rodaresse comando
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double valor1, valor2, resultado;
    char operacao;

    System.out.println("Calculadora Simples em Java");
    System.out.print("Digite o primeiro número: ");
    valor1 = scanner.nextDouble();

    System.out.print("Digite a operacao (+, -, *, /): ");
    operacao = scanner.next().charAt(0);

    System.out.print("Digite o segundo número: ");
    valor2 = scanner.nextDouble();

    switch (operacao) {
        case '+':
            resultado = valor1 + valor2;
            break;
        case '-':
            resultado = valor1 - valor2;
            break;
        case '*':
            resultado = valor1 * valor2;
            break;
        case '/':
            if (num2 != 0) {
                resultado = valor1 / valor2;
            } else {
                System.out.println("Erro: Divisão por zero não é permitida.");
                return;
            }
            break;
        default:
            System.out.println("Operador inválido.");
            return;
    }

    System.out.println("Resultado: " + resultado);
}
}
