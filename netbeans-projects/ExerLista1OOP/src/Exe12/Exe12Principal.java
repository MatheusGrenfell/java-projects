package Exe12;

import java.util.Scanner;

public class Exe12Principal {

    public Exe12Principal() {
        Scanner scan = new Scanner(System.in);
        Fusorario fusorario = new Fusorario();
        System.out.println("Fusor�rio");
        System.out.println(fusorario.getPaises());
        System.out.println("Entre com o pa�s de origem");
        String paisOrigem = scan.next();
        System.out.println("Entre com o pa�s de destino");
        String paisDestino = scan.next();
        System.out.println("Entre com a hora atual");
        int hora = scan.nextInt();
        System.out.println(fusorario.getFusorario(paisOrigem, paisDestino, hora));
    }
}
