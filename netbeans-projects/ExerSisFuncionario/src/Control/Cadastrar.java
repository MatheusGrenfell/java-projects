package Control;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Funcionario;

public class Cadastrar {

    private List<Funcionario> lista = new ArrayList<Funcionario>();

    public void addFuncionario(Funcionario funcionario) {
        lista.add(funcionario);
    }

    public String getSaida() {
        int idade1 = 0, idade2 = 0, idade3 = 0, idade4 = 0, gerente = 0,
                secretaria = 0, programador = 0, anSistemas = 0, webDesigner = 0, suporte = 0;
        double valorMaiorSal = -1;
        String nomeMaiorSal = "";
        for (Funcionario funcionario : lista) {
            if (funcionario.getIdade() >= 16 && funcionario.getIdade() <= 26) {
                idade1++;
            } else {
                if (funcionario.getIdade() >= 27 && funcionario.getIdade() <= 40) {
                    idade2++;
                } else {
                    if (funcionario.getIdade() >= 41 && funcionario.getIdade() <= 50) {
                        idade3++;
                    } else {
                        idade4++;
                    }
                }
            }
            if (funcionario.getCargo().equals("Gerente")) {
                gerente++;
            } else {
                if (funcionario.getCargo().equals("Secret�ria")) {
                    secretaria++;
                } else {
                    if (funcionario.getCargo().equals("Programador")) {
                        programador++;
                    } else {
                        if (funcionario.getCargo().equals("Analista de Sistemas")) {
                            anSistemas++;
                        } else {
                            if (funcionario.getCargo().equals("Web-Designer")) {
                                webDesigner++;
                            } else {
                                suporte++;
                            }
                        }
                    }
                }
            }
            if (funcionario.getSalarioLiquido() > valorMaiorSal) {
                valorMaiorSal = funcionario.getSalarioLiquido();
                nomeMaiorSal = funcionario.getNome();
            }
        }
        if (!lista.isEmpty()) {
            String saida = "N�mero de funcion�rios que foram cadastrados: " + lista.size();
            saida += "\nN�mero de funcion�rios com idade entre 16 � 26 anos: " + idade1;
            saida += "\nN�mero de funcion�rios com idade entre 27 � 40 anos: " + idade2;
            saida += "\nN�mero de funcion�rios com idade entre 41 � 50 anos: " + idade3;
            saida += "\nN�mero de funcion�rios com idade superior a 50 anos: " + idade4;
            saida += "\nN�mero de funcion�rios com os cargos de Gerente: " + gerente;
            saida += "\nN�mero de funcion�rios com os cargos de Secret�ria: " + secretaria;
            saida += "\nN�mero de funcion�rios com os cargos de Programador: " + programador;
            saida += "\nN�mero de funcion�rios com os cargos de Analista de Sistemas: " + anSistemas;
            saida += "\nN�mero de funcion�rios com os cargos de Web-Designer: " + webDesigner;
            saida += "\nN�mero de funcion�rios com os cargos de Suporte: " + suporte;
            saida += "\nFuncion�rio com o maior sal�rio l�quido: " + nomeMaiorSal + ", valor do sal�rio R$ " + NumberFormat.getCurrencyInstance().format(valorMaiorSal);
            return saida;
        }
        return null;
    }
}
