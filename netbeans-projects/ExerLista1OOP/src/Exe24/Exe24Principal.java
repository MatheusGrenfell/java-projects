package Exe24;

import java.util.Scanner;

public class Exe24Principal {

    public Exe24Principal() {
        Scanner scan = new Scanner(System.in);
        Calcula calcula = new Calcula();
        System.out.println("C�lculo custo do consumidor");
        System.out.println("Entre com o valor de f�brica do autom�vel");
        System.out.println(calcula.getCustoConsumidor(scan.nextDouble()));
    }
}
