package Exe11;

import java.util.Scanner;

public class Exe11Principal {

    public Exe11Principal() {
        Scanner sca = new Scanner(System.in);
        System.out.println("C�lculo multa");
        System.out.println("Entre com a velocidade m�xima permitiva em uma avenida");
        int velMaxPer = sca.nextInt();
        System.out.println("Entre com a velocidade que o motorista estava dirigindo nela");
        int velDirigindo = sca.nextInt();
        Multa multa = new Multa(velMaxPer);
        System.out.println(multa.getMultaPagar(velDirigindo));
    }
}
