package View;

import java.util.Scanner;

public class Exe6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("C�lculo pre�o final autom�vel: impostos 15% e porcentagem revendedor 25%");
        System.out.println("Entre com o nome do autom�vel");
        String nomeAuto = scan.nextLine();
        System.out.println("Entre com o pre�o de f�brica");
        double precoFabrica = scan.nextDouble();

        System.out.println("Nome autom�vel: " + nomeAuto);
        System.out.println("Pre�o final: " + (precoFabrica * 1.40));
    }
}
