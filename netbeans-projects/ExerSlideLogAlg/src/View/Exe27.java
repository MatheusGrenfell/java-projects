package View;

import java.util.Scanner;

public class Exe27 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("C�lculo volume de uma lata de �leo");
        System.out.println("Entre com  o raio da lata");
        double raio = scan.nextDouble();
        System.out.println("Entre com a altura da lata");
        double altura = scan.nextDouble();
        System.out.println("Volume: = " + (3.14159265358979 * (raio * raio) * altura));
    }
}
