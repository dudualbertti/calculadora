package matheus_weiber.calculadorajava;
import java.util.Scanner;

public class Calculadora 
{
    static void MenuDeCalculo ()
    {
        Scanner scan = new Scanner(System.in) ;
        System.out.println ("Insira um numero ");
        Double Valor1 = scan.nextDouble() ;
        System.out.println ("Deseja realizar : \n Soma (+)\n Subtraçao (-) \n Multiplicar (*) \n Dividir (/)\n");
        String Operador = scan.next();
        
        System.out.println ("Insira um numero ");
        Double Valor2 = scan.nextDouble() ;
        Calcular(Operador, Valor1, Valor2);
    }
    static void Calcular (String Operador,Double Valor1, Double Valor2)
    {
    switch (Operador) {
            case "+" :
            {   Double Resultado;
                Resultado = Valor1 + Valor2;
                System.out.println(Resultado);
                break;
            }
              case "-"  :
              {
                Double Resultado;
                Resultado = Valor1 - Valor2;
                System.out.println(Resultado);
                break;
              }
                case "*" :
                {
                    Double Resultado;
                Resultado = Valor1 * Valor2;
                System.out.println(Resultado);
                    break;
                } 
                case "/" :
                {
                if(Valor2 != 0)
                    {
                     Double Resultado;
                     Resultado = Valor1 / Valor2;
                     System.out.println(Resultado);
                    }
                 else
                 {
                    System.out.println("Operaçao nao pode ser feita pois o divisor e 0");
                 }
                    break;
                }
        
           
        }
    }
    public static void main(String[] args)
    {
        MenuDeCalculo();
    }
}