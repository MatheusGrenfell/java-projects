package View;

import java.util.Scanner;

public class Exe6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome, linha = null, sexo;
        int idade, contM = 0, contF = 0, infantilA = 0, infantilB = 0, juvenilA = 0, juvenilB = 0,
                master = 0, adultoA = 0, adultoB = 0, qtdade = 0;
        System.out.println("Sistema de competi��o de nata��o");
        while (true) {
            System.out.println("Entre com o nome ou digite Terminar para encerrar o programa");
            if (linha != null) {
                scan.nextLine();
            }
            linha = scan.nextLine();
            nome = linha;
            if (nome.equalsIgnoreCase("Terminar")) {
                break;
            }
            while (true) {
                System.out.println("Entre com a idade");
                idade = scan.nextInt();
                if (idade >= 0) {
                    break;
                }
                System.out.println("Idade inv�lida");
            }
            if (idade >= 0 && idade <= 6) {
                System.out.println("N�o poder� participar");
            } else {
                if (idade > 30) {
                    System.out.println("Idade inv�lida para participar da competi��o");
                } else {
                    qtdade++;
                    while (true) {
                        System.out.println("Entre com o sexo: M/F");
                        sexo = scan.next();
                        if (sexo.equalsIgnoreCase("M")) {
                            contM++;
                            break;
                        } else {
                            if (sexo.equalsIgnoreCase("F")) {
                                contF++;
                                break;
                            } else {
                                System.out.println("Sexo inv�lido");
                            }
                        }
                    }
                    if (idade >= 7 && idade <= 9) {
                        infantilA++;
                    } else {
                        if (idade >= 10 && idade <= 11) {
                            infantilB++;
                        } else {
                            if (idade >= 12 && idade <= 14) {
                                juvenilA++;
                            } else {
                                if (idade >= 15 && idade <= 17) {
                                    juvenilB++;
                                } else {
                                    if (idade >= 18 && idade <= 22) {
                                        master++;
                                    } else {
                                        if (idade >= 23 && idade <= 27) {
                                            adultoA++;
                                        } else {
                                            adultoB++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (qtdade != 0) {
            System.out.println("Quantidade 7 � 9 � Infantil A: " + infantilA);
            System.out.println("Quantidade 10 � 11 � Infantil B: " + infantilB);
            System.out.println("Quantidade 12 � 14 � Juvenil A: " + juvenilA);
            System.out.println("Quantidade 15 � 17 � Juvenil B: " + juvenilB);
            System.out.println("Quantidade 18 � 22 � Master: " + master);
            System.out.println("Quantidade 23 � 27 � Adulto A: " + adultoA);
            System.out.println("Quantidade 28 � 30 � Adulto B: " + adultoB);
            System.out.println("Est�o participando " + contM + " homens");
            System.out.println("Est�o participando " + contF + " mulheres");
            if (contM == contF) {
                System.out.println("H� o mesmo tanto de homens e mulheres");
            } else {
                if (contF > contM) {
                    System.out.println("H� mais mulheres do que homens");
                } else {
                    System.out.println("H� mais homens do que mulheres");
                }
            }
        }
    }
}
