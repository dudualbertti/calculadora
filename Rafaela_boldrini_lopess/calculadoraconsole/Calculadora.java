import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o primeiro número:");
        Double val1 = input.nextDouble();

        System.out.println("Insira o segundo número:");
        Double val2 = input.nextDouble();

        String options = "Informe a operação:\n[01] Soma\n[02] Subtração\n[03] Multiplicação\n[04] Divisão";
        System.out.println(options);

        
        int escolha = input.nextInt();

        
        double resultado = 0;
        String operacao = "";

        switch (escolha) {
            case 1:
                resultado = val1 + val2;
                operacao = "soma";
                break;
            case 2:
                resultado = val1 - val2;
                operacao = "subtração";
                break;
            case 3:
                resultado = val1 * val2;
                operacao = "multiplicação";
                break;
            case 4:
                if (val2 != 0.0) {
                    resultado = val1 / val2;
                    operacao = "divisão";
                } else {
                    System.out.println("Não é possível dividir por zero.");
                    input.close();
                    return;
                }
                break;
            default:
                System.out.println("Escolha inválida.");
                input.close();
                return;
        }

        System.out.println("Resultado da " + operacao + ": " + resultado);

        input.close();
    }
}