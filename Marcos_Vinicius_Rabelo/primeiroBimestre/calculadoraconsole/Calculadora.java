import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Calculadora {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o primeiro valor");
        Double valor1 = input.nextDouble();

        System.out.println("Insira o segundo valor");
        Double valor2 = input.nextDouble();

        if (valor2 == 0d) {
            throw new RuntimeException("O valor inserido é inválido");
            
        }

        System.out.println(
                "Qual é a operação desejada ? \n [1]-> Soma \n [2]-> Subtração \n [3]-> Multiplicação \n [4]-> Divisão ");
        int escolha = input.nextInt();

        switch (escolha) {
            case 1:
                System.out.println(valor1 + valor2);
                break;

            case 2:
                System.out.println(valor1 - valor2);
                break;

            case 3:
                System.out.println(valor1 * valor2);
                break;

            case 4:
                System.out.println(valor1 / valor2);
                break;

        }
    }
}
