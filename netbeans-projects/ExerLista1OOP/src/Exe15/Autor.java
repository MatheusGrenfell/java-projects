package Exe15;

public class Autor {

    public String getAutores() {
        return "Autores:\nMonteiro Lobato\nClarisse Lispector\nFernando Pessoa";
    }

    public String getDadosAutor(String nome) {
        if (nome.equalsIgnoreCase("Monteiro Lobato")) {
            return "Nome: Monteiro Lobato"
                    + "\nProfiss�o: Escritor"
                    + "\nIdade: 80";
        }
        if (nome.equalsIgnoreCase("Clarisse Lispector")) {
            return "Nome: Clarisse Lispector"
                    + "\nProfiss�o: Escritora"
                    + "\nIdade: 72";
        }
        if (nome.equalsIgnoreCase("Fernando Pessoa")) {
            return "Nome: Fernando Pessoa"
                    + "\nProfiss�o: Poeta"
                    + "\nIdade: 79";
        }
        return "nome n�o existe";
    }
}
