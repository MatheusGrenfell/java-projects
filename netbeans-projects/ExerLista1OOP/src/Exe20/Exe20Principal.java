package Exe20;

import java.util.Scanner;

public class Exe20Principal {

    public Exe20Principal() {
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
        Quadrado quadrado = new Quadrado(lado1, lado2, lado3, lado4);
        System.out.println(quadrado.isQuadrado());
    }
}
