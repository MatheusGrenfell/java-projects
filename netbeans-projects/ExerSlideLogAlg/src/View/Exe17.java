package View;

import java.util.Scanner;

public class Exe17 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Soma de diversos n�meros inteiros");
        int i = 1, soma = 0, num;
        while (true) {
            System.out.println("Entre com o " + i + "� n�mero");
            num = scan.nextInt();
            if (num == -1) {
                break;
            } else {
                soma += num;
            }
            i++;
        }
        System.out.println("A soma de todos os n�meros � " + soma);
    }
}
