package Lucas_Schiroff.calculadoraconsole;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Calculadora{
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        String texto = ("Qual a operação que deseja realizar ? \n[1]Soma \n[2]Subtração \n[3]Multiplicação \n[4]Divisão \n[5]sair");
        System.out.println(texto);
        int escolha = input.nextInt();

        System.out.println("insira o primeiro numero");
        Double val1 = input.nextDouble();

        System.out.println("insira o segundo numero");
        Double val2 = input.nextDouble();

        if(val2 == 0.0){
            throw new RuntimeException("Valor inserido invalido");
        }

        System.out.println(escolha);

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
        }

        System.out.println(val1);        
        System.out.println(val2);
        
    }
 
}