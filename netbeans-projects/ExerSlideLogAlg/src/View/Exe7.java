package View;

import java.util.Scanner;

public class Exe7 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String linha = "";
        System.out.println("Informa��es funcion�rio");
        System.out.println("Entre com o nome");
        String nome = scan.nextLine();
        System.out.println("Entre com a idade");
        int idade = scan.nextInt();
        System.out.println("Entre com o cargo");
        if (linha != null) {
            scan.nextLine();
        }
        linha = scan.nextLine();
        String cargo = linha;
        System.out.println("Entre com o sal�rio bruto");
        double salarioBruto = scan.nextDouble();
        double salTotal = salarioBruto + (salarioBruto * 0.38);
        double salLiquido = (salTotal - (salTotal * 0.15)) + (salarioBruto * 0.20);
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Cargo: " + cargo);
        System.out.println("Sal�rio Bruto: " + salarioBruto);
        System.out.println("Sal�rio L�quido: " + salLiquido);
    }
}
