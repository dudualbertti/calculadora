package Maria_Eduarda_Bergamin.calculadoraconsole;
import java.util.Scanner;


public class Calculadora {


    public static void main(String[] args) {
           
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
       
        String texto = "Selecione a operacao:\n1.Soma\n2.Subtracao\n3.Multiplicaçao\n4.Divisao\n5.Sair";
        System.out.println(texto);
        int escolha = input1.nextInt();


        System.out.println("Insira o primeiro numero: ");
        double val1 = input.nextDouble();
       
        System.out.println("Insira o segundo numero: ");
        double val2 = input.nextDouble();
   
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





