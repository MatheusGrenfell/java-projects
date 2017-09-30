package TabelaHash;

public class TabelaHashMain {

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(13);
        tabelaHash.set("Caio", 2345, 9);
        tabelaHash.set("Renan", 74, 8);
        tabelaHash.set("Jo�o", 25, 6);
        tabelaHash.set("Sousa", 4545, 5);
        tabelaHash.set("Carla", 25, 6);
        tabelaHash.set("Morais", 253, 2);
        System.out.println("Conte�do da Tabela Hash");
        System.out.println(tabelaHash.toString());
        System.out.println();
        int n = 25;
        tabelaHash.remove(25);
        System.out.println("Conte�do da Tabela Hash ap�s ter removido o aluno com a matr�cula " + n);
        System.out.println(tabelaHash.toString());
        int y = 253;
        if (tabelaHash.get(y) == null) {
            System.out.println("Aluno n�o encontrado");
        } else {
            System.out.println("Aluno Recuperado: ");
            System.out.println("Matr�cula: " + tabelaHash.get(y).getMatricula());
            System.out.println("Nome: " + tabelaHash.get(y).getNome());
            System.out.println("M�dia Geral: " + tabelaHash.get(y).getMediaGeral());
        }
        System.out.println("Tamanho da Tabela Hash: " + tabelaHash.size());
        System.out.println("Tabela ordenada pela matr�cula");
        Aluno aluno[] = tabelaHash.ordena();
        for (int i = 0; i < aluno.length; i++) {
            System.out.println("Matr�cula: " + aluno[i].getMatricula() + ", Nome: " + aluno[i].getNome() + ", M�dia Geral: " + aluno[i].getMediaGeral());
        }
        tabelaHash.set("sgdh", 987, 4);
        System.out.println("Conte�do da Tabela Hash");
        System.out.println(tabelaHash.toString());
        System.out.println();
        Aluno aluno2[] = tabelaHash.ordena();
        for (int i = 0; i < aluno2.length; i++) {
            System.out.println("Matr�ula: " + aluno2[i].getMatricula() + ", Nome: " + aluno2[i].getNome() + ", M�dia Geral: " + aluno2[i].getMediaGeral());
        }
    }
}
