package View;

import java.util.Scanner;

public class Exe22 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Calculo Velocidade M�dia");
        System.out.println("Entre com o espa�o percorrido em metros");
        double espaco = scan.nextDouble();
        System.out.println("Tempo utilizado para percorrer o espa�o informado em segundos");
        double tempo = scan.nextDouble();
        System.out.println("Velocidade M�dia " + (espaco / tempo) + " m/s");
    }
}
