package View;

import java.util.Scanner;

public class Exe19 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ret�ngulo");
        System.out.println("Entre com a altura");
        double altura = scan.nextDouble();
        System.out.println("Entre com a largura");
        double largura = scan.nextDouble();
        System.out.println("�rea: " + (largura * altura));
        System.out.println("Pe�metro: " + ((largura * 2) + (altura * 2)));
    }
}
