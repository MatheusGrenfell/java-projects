package View;

import java.util.Scanner;

public class Exe29 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Exerc�cio quociente");
        System.out.println("Entre com um n�mero");
        double num1 = scan.nextDouble();
        System.out.println("Entre com o segundo n�mero");
        double num2 = scan.nextDouble();
        int quociente = (int) (num1 / num2);
        System.out.println("Quociente: " + quociente);
    }
}
