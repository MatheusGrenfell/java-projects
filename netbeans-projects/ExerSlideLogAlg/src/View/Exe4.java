package View;

import java.util.Scanner;

public class Exe4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entre com os dados de um tri�ngulo");
        System.out.println("Entre com a base");
        double base = scan.nextDouble();
        System.out.println("Entre com a altura");
        double altura = scan.nextDouble();

        System.out.println("�rea do tri�ngulo: " + (base * altura) / 2);
    }
}
