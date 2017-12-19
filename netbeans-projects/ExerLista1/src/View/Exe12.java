package View;

import java.util.Scanner;

public class Exe12 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int paisOrigem;
        while (true) {
            System.out.println("Entre com o n�mero pa�s de origem:");
            System.out.println("1 - Brasil");
            System.out.println("2 - Inglaterra");
            System.out.println("3 - Alemanha");
            paisOrigem = scan.nextInt();
            if (paisOrigem >= 1 && paisOrigem <= 3) {
                break;
            } else {
                System.out.println("Entre com uma das op��es v�lidas");
            }
        }
        int hora;
        while (true) {
            System.out.println("Entre com a hora atual:");
            hora = scan.nextInt();
            if (hora >= 0 && hora <= 23) {
                break;
            } else {
                System.out.println("Hora inv�lida");
            }
        }
        int paisDestino;
        while (true) {
            System.out.println("Entre com o n�mero pa�s de destino:");
            System.out.println("1 - Brasil");
            System.out.println("2 - Inglaterra");
            System.out.println("3 - Alemanha");
            paisDestino = scan.nextInt();
            if (paisDestino >= 1 && paisDestino <= 3) {
                break;
            } else {
                System.out.println("Entre com uma das op��es v�lidas");
            }
        }
        switch (paisOrigem) {
            case 1:
                switch (paisDestino) {
                    case 1:
                        System.out.println("Hor�rio no Brasil: " + hora + " Horas");
                        break;
                    case 2:
                        hora += 3;
                        if (hora > 23) {
                            System.out.println("Hor�rio na Inglaterra: " + (hora - 24) + " Horas");
                        } else {
                            System.out.println("Hor�rio na Inglaterra: " + hora + " Horas");
                        }
                        break;
                    case 3:
                        hora += 4;
                        if (hora > 23) {
                            System.out.println("Hor�rio na Alemanha: " + (hora - 24) + " Horas");
                        } else {
                            System.out.println("Hor�rio na Alemanha: " + hora + " Horas");
                        }
                        break;
                }
                break;
            case 2:
                switch (paisDestino) {
                    case 1:
                        hora -= 3;
                        if (hora < 0) {
                            System.out.println("Hor�rio no Brasil: " + (hora + 24) + " Horas");
                        } else {
                            System.out.println("Hor�rio no Brasil: " + hora + " Horas");
                        }
                        break;
                    case 2:
                        System.out.println("Hor�rio na Inglaterra: " + hora + " Horas");
                        break;
                    case 3:
                        hora += 1;
                        if (hora > 23) {
                            System.out.println("Hor�rio na Alemanha: " + (hora - 24) + " Horas");
                        } else {
                            System.out.println("Hor�rio na Alemanha: " + hora + " Horas");
                        }
                        break;
                }
                break;
            case 3:
                switch (paisDestino) {
                    case 1:
                        hora -= 4;
                        if (hora < 0) {
                            System.out.println("Hor�rio no Brasil: " + (hora + 24) + " Horas");
                        } else {
                            System.out.println("Hor�rio no Brasil: " + hora + " Horas");
                        }
                        break;
                    case 2:
                        hora -= 1;
                        if (hora < 0) {
                            System.out.println("Hor�rio na Inlaterra: " + (hora + 24) + " Horas");
                        } else {
                            System.out.println("Hor�rio na Inglaterra: " + hora + " Horas");
                        }
                        break;
                    case 3:
                        System.out.println("Hor�rio na Alemanha: " + hora + " Horas");
                        break;
                }
                break;
        }
    }
}
