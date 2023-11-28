package Lucas_Dos_Santos_Lourenco.calculadoraconsole;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o primeiro número: ");
        double val1 = input.nextDouble();

        System.out.println("Insira o segundo número: ");
        double val2 = input.nextDouble();

        if (val2 == 0d) {
            throw new RuntimeException("Valor inserido inválido");
        }

        String texto = "Qual a operação que você deseja realizar?: \n[1]Soma\n[2] Subtração\n[3]Multiplicação\n[4] divisão";
        System.out.println(texto);
        int escolha = input.nextInt();

      

        switch (escolha) {
            case 1:
                System.out.println(val1 + val2);
                break;
            case 2:
                System.out.println(val1 - val2);
                break;
            case 3:
                System.out.println(val1 * val2);
                break;
            case 4:
                System.out.println(val1 / val2);

                break;

            default:
                break;
        }
    }

    static void teste(double valorUm) {

    }
}