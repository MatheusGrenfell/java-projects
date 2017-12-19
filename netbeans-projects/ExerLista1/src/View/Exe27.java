package View;

import java.util.Scanner;

public class Exe27 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Calend�rio 2010");
        String[] semana = {"Domingo", "Segunda-Feira", "Ter�a-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "S�bado"};
        String[] feriados = {"Dia 01 - Confraterniza��o Universal",
            "Dia 16 - Carnaval", "N�o tem feriados",
            "Dia 02 - Paix�o\nDia 04 - P�scoa\nDia 21 - Tiradentes",
            "Dia 01 - Dia do Trabalhor", "Dia 03 - Corpus Christi",
            "N�o tem feriados", "N�o tem feriados",
            "Dia 07 - Proclama��o da Independ�ncia",
            "Dia 12 - Nossa Senhora de Aparecida",
            "Dia 02 - Dia de Finados\nDia 15 - Proclama��o da Rep�blica",
            "Dia 25 - Natal"};
        System.out.println("Entre com o m�s");
        int mes = scan.nextInt();
        if (mes >= 1 && mes <= 12) {
            System.out.println("Entre com o dia ou digite 0 para visualizar os feriados do m�s");
            int dia = scan.nextInt();
            if (dia == 0) {
                System.out.println("Feriados:");
                System.out.println(feriados[mes - 1]);
            } else {
                int[] diaLimiteMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};// limite de cada m�s
                int[] primDiaSemana = {6, 2, 2, 5, 7, 3, 5, 1, 4, 6, 2, 4};// dias que  se iniciam a semana no m�s
                int diaLimite = diaLimiteMes[mes - 1];
                if (dia >= 1 && dia <= diaLimite) {
                    int cont = primDiaSemana[mes - 1];
                    for (int i = 0; i < diaLimite; i++) {
                        while (cont > 7) {
                            cont -= 7;
                        }
                        if (dia - 1 == i) {
                            System.out.println("Dia da semana: " + semana[cont - 1]);
                            break;
                        }
                        cont++;
                    }
                } else {
                    System.out.println("Entre com um dia v�lido");
                }
            }
        } else {
            System.out.println("Entre com um m�s v�lido");
        }
    }
}
