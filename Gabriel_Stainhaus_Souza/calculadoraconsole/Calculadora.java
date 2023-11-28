package calculadoraconsolee;

import java.util.Scanner;

public class Calculadora{

    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        String text = "Qual operação deseja realizar?:\n [1] Adição\n [2] Subtração\n [3] Multiplicação\n [4] Divisão\n [5] Sair";
        System.out.println(text);
        int escolha = scan.nextInt();
        Double val1 = 0.0, val2 = 0.0;+

        if(escolha == 5){

            System.out.println("Obrigado por usar meu programa!");

        }else{

            System.out.println("Insira o primeiro número:");
            val1 = scan.nextDouble();

            System.out.println("Insira o segundo número:");
            val2 = scan.nextDouble();

            if (val2 == 0d){
                throw new RuntimeException("Valor inserido inválido");
            }

        }

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
            case 5:
                break;
            default:
                break;
        }

    }
}     