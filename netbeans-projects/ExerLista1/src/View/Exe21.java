package View;

import java.util.Scanner;

public class Exe21 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("C�lculo conta hotel");
        System.out.println("Op��es");
        System.out.println("1 - apto simples");
        System.out.println("2 - apto duplo");
        System.out.println("3 - su�te luxo");
        while (true) {
            System.out.println("Entre com uma das op��es");
            int opcao = scan.nextInt();
            if (opcao >= 1 && opcao <= 3) {
                System.out.println("Entre com a quantidade de dias");
                int qtdadeDias = scan.nextInt();
                if (opcao == 1) {
                    System.out.println("Valor a ser pago: R$ " + (qtdadeDias * 45) + ",00 por dia");
                    break;
                } else {
                    if (opcao == 2) {
                        System.out.println("Valor a ser pago: R$ " + (qtdadeDias * 65) + ",00 por dia");
                        break;
                    } else {
                        System.out.println("Valor a ser pago: R$ " + (qtdadeDias * 110) + ",00 por dia");
                        break;
                    }
                }
            } else {
                System.out.println("Entre com uma op��o v�lida");
            }
        }
    }
}
