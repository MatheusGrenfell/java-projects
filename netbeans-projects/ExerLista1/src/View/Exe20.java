package View;

import java.util.Scanner;

public class Exe20 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Verifica se objeto � quadrado ou n�o");
        System.out.println("Entre com o primeiro lado");
        double lado1 = scan.nextDouble();
        System.out.println("Entre com o segundo lado");
        double lado2 = scan.nextDouble();
        System.out.println("Entre com o terceiro lado");
        double lado3 = scan.nextDouble();
        System.out.println("Entre com o quarto lado");
        double lado4 = scan.nextDouble();
        if (lado1 == lado2 && lado1 == lado3 && lado1 == lado4) {
            System.out.println("Objeto analisado � um quadrado");
        } else {
            System.out.println("Objeto informado n�o � um quadrado");
        }
    }
}
