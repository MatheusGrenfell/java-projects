package Exe29;

import java.util.Scanner;

public class Exe29Principal {

    public Exe29Principal() {
        Scanner scan = new Scanner(System.in);
        Quociente quociente = new Quociente();
        System.out.println("Exerc�cio quociente");
        System.out.println("Entre com um n�mero");
        double num1 = scan.nextDouble();
        System.out.println("Entre com o segundo n�mero");
        double num2 = scan.nextDouble();
        System.out.println(quociente.getQuociente(num1, num2));
    }
}
