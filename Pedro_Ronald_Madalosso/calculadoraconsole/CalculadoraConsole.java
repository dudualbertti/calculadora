import java.util.Scanner;

public class CalculadoraConsole {

  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Digite o primeiro número: ");
    double num1 = scanner.nextDouble();
    
    System.out.print("Digite o segundo número: ");
    double num2 = scanner.nextDouble();
    
    System.out.print("Escolha a operação (+, -, *, /): ");
    String op = scanner.next();
    
    double resultado;
    
    if (op.equals("+")) {
      resultado = num1 + num2;
    } else if (op.equals("-")) { 
      resultado = num1 - num2;
    } else if (op.equals("*")) {
      resultado = num1 * num2;
    } else if (op.equals("/")) {
      resultado = num1 / num2;
    } else {
      System.out.println("Operação inválida!");
      return;
    }
    
    System.out.println("Resultado: " + resultado);
  }

}