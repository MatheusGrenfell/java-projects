package View;

import java.util.Scanner;

public class Exe2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Calend�rio maio de 2010");
        System.out.println("Entre com o dia do m�s ou digite a palavra feriado para exibir os feriados do m�s");
        String dia = scan.next();
        System.out.println("Dia da semana calend�rio maio 2010");
        System.out.println("Dia: " + dia);
        if (dia.equals("1") || dia.equals("8") || dia.equals("15") || dia.equals("22") || dia.equals("29")) {
            System.out.println("Dia da semana � s�bado");
        } else {
            if (dia.equals("2") || dia.equals("9") || dia.equals("16") || dia.equals("23") || dia.equals("30")) {
                System.out.println("Dia da semana � domingo");
            } else {
                if (dia.equals("3") || dia.equals("10") || dia.equals("17") || dia.equals("24") || dia.equals("31")) {
                    System.out.println("Dia da semana � segunda");
                } else {
                    if (dia.equals("4") || dia.equals("11") || dia.equals("18") || dia.equals("25")) {
                        System.out.println("Dia da semana � ter�a");
                    } else {
                        if (dia.equals("5") || dia.equals("12") || dia.equals("19") || dia.equals("26")) {
                            System.out.println("Dia da semana � quarta");
                        } else {
                            if (dia.equals("6") || dia.equals("13") || dia.equals("20") || dia.equals("27")) {
                                System.out.println("Dia da semana � quinta");
                            } else {
                                if (dia.equals("7") || dia.equals("14") || dia.equals("21") || dia.equals("28")) {
                                    System.out.println("Dia da semana � sexta");
                                } else {
                                    if (dia.equalsIgnoreCase("feriado")) {
                                        System.out.println("Feriados");
                                        System.out.println("Dia 1�, s�bado dia do trabalhador");
                                        System.out.println("Dia 9, domingo dia das m�es");
                                    } else {
                                        System.err.println("Informe um dia v�lido");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
