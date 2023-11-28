import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o primeiro valor:");
        double val1 = input.nextDouble();

        System.out.println("Insira o segundo valor:");
        double val2 = input.nextDouble();

        String texto = "Qual operação deseja realizar?\n[1] Soma\n[2] Subtração\n[3] Multiplicação\n[4] Divisão";
        System.out.println(texto);
        int escolha = input.nextInt();

        System.out.println("Escolha: " + escolha);
        System.out.println("Valor 1: " + val1);
        System.out.println("Valor 2: " + val2);

        switch (escolha) {
            case 1:
                soma(val1, val2);
                break;
            case 2:
                subtracao(val1, val2);
                break;
            case 3:
                multiplicacao(val1, val2);
                break;
            case 4:
                divisao(val1, val2);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        
        input.close();
    }

    static void soma(double valorUm, double valorDois) {
        double resultado = valorUm + valorDois;
        System.out.println("Resultado da soma: " + resultado);
    }

    static void subtracao(double valorUm, double valorDois) {
        double resultado = valorUm - valorDois;
        System.out.println("Resultado da subtração: " + resultado);
    }

    static void multiplicacao(double valorUm, double valorDois) {
        double resultado = valorUm * valorDois;
        System.out.println("Resultado da multiplicação: " + resultado);
    }

    static void divisao(double valorUm, double valorDois) {
        if (valorDois != 0) {
            double resultado = valorUm / valorDois;
            System.out.println("Resultado da divisão: " + resultado);
        } else {
            System.out.println("Erro: divisão por zero!");
        }
    }
}

























