package br.fag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String texto = "Selecione a opção desejada: \n1 - Adição: \n2 - Subtração:\n3 - Multiplicação:\n4 - Divisão:\n5 - Sair";
        System.out.println(texto);
        int opcao = input.nextInt();
        System.out.println(opcao);

        System.out.println("Insira o primeiro valor:");
        double num1 = input.nextDouble();

        System.out.println("Insira o segundo valor:");
        double num2 = input.nextDouble();

        switch (opcao) {
            case 1:
                System.out.println(num1 + num2);

                break;
            case 2:
                System.out.println(num1 - num2);
                break;
            case 3:
                System.out.println(num1 * num2);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Não é possivel realizar essa operação!");

                    return;
                }
                
                System.out.println(num1 / num2);

                break;
            case 5:
                System.out.println("Sair");
                break;

            default:
                break;
        }

    }
}