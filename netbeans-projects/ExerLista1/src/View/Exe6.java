package View;

import java.util.Scanner;

public class Exe6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sal�rio do usu�rio");
        System.out.println("Entre com o n�mero de horas trabalhadas");
        int numHoras = scan.nextInt();
        System.out.println("Entre com o valor das horas");
        double valorHora = scan.nextDouble();
        System.out.println("Entre com o n�mero de horas extras (50%) trabalhadas");
        int numHorasExtras50 = scan.nextInt();
        System.out.println("Entre com o n�mero de horas extras (100%) trabalhadas");
        int numHorasExtras100 = scan.nextInt();
        double salario = (numHoras * valorHora) + ((valorHora * 1.5) * numHorasExtras50) + ((valorHora * 2) * numHorasExtras100);
        System.out.println("Sal�rio bruto: " + salario);
    }
}
