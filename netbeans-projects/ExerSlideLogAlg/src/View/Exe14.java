package View;

import java.util.Scanner;

public class Exe14 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Verifica se n�mero � positivo ou negativo");
        System.out.println("Entre com um n�mero");
        int num = scan.nextInt();
        if (num == 0) {
            System.out.println("N�mero zero");
        } else {
            if (num > 0) {
                System.out.println("N�mero positivo");
            } else {
                System.out.println("N�mero negativo");
            }
        }
        if (num % 2 == 0) {

            System.out.println("N�mero par");
        } else {
            System.out.println("N�mero �mpar");
        }
    }
}
