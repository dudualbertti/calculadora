package br.fag.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        double num1, num2;
        int key = 0;

        try {
            System.out.println("Escolha qual operação você deseja utilizar?");
            System.out.println("1 - Adição");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplição");
            System.out.println("4 - Divisão");

            key = read.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Você pode utilizar nada além de números!");
        }

        switch (key) {
            case 1:

                System.out.println("Digite seu primeiro valor: ");
                num1 = read.nextFloat();

                System.out.println("Digite seu segundo valor: ");
                num2 = read.nextFloat();
                adicao(num1, num2);
                break;
            case 2:

                System.out.println("Digite seu primeiro valor: ");
                num1 = read.nextFloat();

                System.out.println("Digite seu segundo valor: ");
                num2 = read.nextFloat();
                subtracao(num1, num2);
                break;
            case 3:

                System.out.println("Digite seu primeiro valor: ");
                num1 = read.nextFloat();

                System.out.println("Digite seu segundo valor: ");
                num2 = read.nextFloat();
                multiplicacao(num1, num2);
                break;
            case 4:

                System.out.println("Digite seu primeiro valor: ");
                num1 = read.nextFloat();

                System.out.println("Digite seu segundo valor: ");
                num2 = read.nextFloat();
                divisao(num1, num2);
                break;

            default:
                System.out.println("Nesse campo você só pode utilizar que estão listados!");

        }
    }

    public static void adicao(double valor1, double valor2) {
        double result = valor1 + valor2;
        System.out.println("Esse é seu resultado: " + result);

    }

    public static void subtracao(double valor1, double valor2) {
        double result = valor1 - valor2;
        System.out.println("Esse é seu resultado: " + result);
    }

    public static void multiplicacao(double valor1, double valor2) {
        double result = valor1 * valor2;
        System.out.println("Esse é seu resultado: " + result);
    }

    public static void divisao(double valor1, double valor2) {
        double result = valor1 / valor2;
        System.out.println("Esse é seu resultado: " + result);
    }
}
