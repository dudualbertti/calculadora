import java.util.Scanner;
public class Calculadora{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o primeiro número");
        Double val1 = input.nextDouble();

        System.out.println("Insira o segundo número");
        Double val2 = input.nextDouble();
        
        String texto = "Qual operação deseja realizar?: \n [1]Soma \n [2]Subtração \n [3]Multiplicação \n [4] Divisão";
        System.out.println(texto);
        int escolha = input.nextInt();
        System.out.println(escolha);

        switch (escolha) {
            case 1:
                System.out.println(val1+val2);
                break;
        
            case 2:
                System.out.println(val1-val2);
                break;
            case 3:
                System.out.println(val1*val2);
                break;
             case 4:
                System.out.println(val1/val2);
                break;    
        }

        

        System.out.println(val1);
        System.out.println(val2);
    }
  
}