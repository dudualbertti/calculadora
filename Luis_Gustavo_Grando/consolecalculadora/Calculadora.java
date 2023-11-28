
import java.util.Scanner;
public class Calculadora{
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        System.out.print("\nInsira o valor 1: ");
        float v1 = s1.nextFloat();
        System.out.print("\n1 - Soma\n2 - Subtração\n3 - Divisão\n4 - Multiplicação\n\nInsira a operação desejada: ");
        int op = s1.nextInt();
        System.out.print("\nInsira o valor 2: ");
        float v2 = s1.nextFLoat();

        switch (op){
            case 1:
                System.out.println("\n"+v1+" + "+v2+" = "+(v1+v2));
                break;

            case 2:
                System.out.println("\n"+v1+" - "+v2+" = "+(v1-v2));
                break;

            case 3:
                System.out.println("\n"+v1+" / "+v2+" = "+(v1/v2));
                break;

            case 4:
                System.out.println("\n"+v1+" * "+v2+" = "+(v1*v2));
                break;

            default:
                System.out.println("Insira uma opção válida!");
        }

    }
}