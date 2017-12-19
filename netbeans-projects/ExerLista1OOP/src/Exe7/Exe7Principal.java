package Exe7;

import java.util.Scanner;

public class Exe7Principal {

    public Exe7Principal() {
        Scanner scan = new Scanner(System.in);
        Controle controle = new Controle();
        controle.addPalavras(new Palavra("Cachorro", "Dog"));
        controle.addPalavras(new Palavra("Tempo", "Time"));
        controle.addPalavras(new Palavra("Amor", "Love"));
        controle.addPalavras(new Palavra("Cidade", "City"));
        controle.addPalavras(new Palavra("Feliz", "Happy"));
        System.out.println("Tradutor");
        System.out.println("1 - Portugu�s para Ingl�s");
        System.out.println("2 - Ingl�s para Portugues");
        System.out.println("Entre com uma das op��es");
        int opcao = scan.nextInt();
        String palavra;
        switch (opcao) {
            case 1:
                System.out.println(controle.getPalavras(opcao));
                System.out.println("Entre com uma das palavras");
                palavra = scan.next();
                System.out.println("Tradu��o: " + controle.getIngles(palavra));
                break;
            case 2:
                System.out.println(controle.getPalavras(opcao));
                System.out.println("Entre com uma das palavras");
                palavra = scan.next();
                System.out.println("Tradu��o: " + controle.getPortugues(palavra));
                break;
            default:
                System.err.println("Palavra inv�lida");
                break;
        }
    }
}
