package View;

import java.util.Scanner;

public class Exe18 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Conversor de moesdas real e dolar");
        System.out.println("Entre com um valor");
        double valor = scan.nextDouble();
        System.out.println("Tipo moeda\n1 - Real para D�lar\n2 - D�lar para Real");
        int tipo = scan.nextInt();
        if (tipo == 1) {
            System.out.println("O valor de R$ " + valor + " � o mesmo que $ " + (valor / 1.85));
        } else {
            if (tipo == 2) {
                System.out.println("O valor de $ " + valor + " � o mesmo que R$ " + (valor * 1.85));
            } else {
                System.out.println("Tipo inv�lido");
            }
        }
    }
}
