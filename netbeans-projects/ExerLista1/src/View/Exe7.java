package View;

import java.util.Scanner;

public class Exe7 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Tradutor");
        System.out.println("1 - Portugu�s para Ingl�s");
        System.out.println("2 - Ingl�s para Portugues");
        System.out.println("Entre com uma das op��es");
        int opcao = scan.nextInt();
        String palavra;
        switch (opcao) {
            case 1:
                System.out.println("Palavras - Portugu�s para Ingl�s");
                System.out.println("Cachorro - Tempo - Amor - Cidade - Feliz");
                System.out.println("Entre com uma das palavras");
                palavra = scan.next();
                if (palavra.equalsIgnoreCase("Cachorro")) {
                    System.out.println("Tradu��o: Dog");
                } else {
                    if (palavra.equalsIgnoreCase("Tempo")) {
                        System.out.println("Tradu��o: Time");
                    } else {
                        if (palavra.equalsIgnoreCase("Amor")) {
                            System.out.println("Tradu��o: Love");
                        } else {
                            if (palavra.equalsIgnoreCase("Cidade")) {
                                System.out.println("Tradu��o: City");
                            } else {
                                if (palavra.equalsIgnoreCase("Feliz")) {
                                    System.out.println("Tradu��o: Happy");
                                } else {
                                    System.err.println("Palavra inv�lida");
                                }
                            }
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Palavras - Ingl�s para Portugues");
                System.out.println("Dog - Time - Love - City - Happy");
                System.out.println("Entre com uma das palavras");
                palavra = scan.next();
                if (palavra.equalsIgnoreCase("Dog")) {
                    System.out.println("Tradu��o: Cachorro");
                } else {
                    if (palavra.equalsIgnoreCase("Time")) {
                        System.out.println("Tradu��o: Tempo");
                    } else {
                        if (palavra.equalsIgnoreCase("Love")) {
                            System.out.println("Tradu��o: Amor");
                        } else {
                            if (palavra.equalsIgnoreCase("City")) {
                                System.out.println("Tradu��o: Cidade");
                            } else {
                                if (palavra.equalsIgnoreCase("Happy")) {
                                    System.out.println("Tradu��o: Feliz");
                                } else {
                                    System.err.println("Palavra inv�lida");
                                }
                            }
                        }
                    }
                }
                break;
            default:
                System.err.println("Op��o inv�lida");
                break;
        }
    }
}
