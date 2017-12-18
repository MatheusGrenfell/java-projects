package produto;

import java.util.List;

public class Teste {

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando a conex�o com o banco de dados");
        ProdutoDAO dao = new ProdutoDAO();

        System.out.println("Criando os produtos.........");
        Produto p;
        for (int i = 0; i < 100; i++) {
            p = new Produto();
            p.setNome("Teste");
            p.setDescricao("Teste descri��o");
            p.setPreco(100.40);
            dao.salva(p);
        }
        System.out.println("produtos criados.........");

        System.out.println("");

        p = dao.procura(12);
        System.out.println("Removendo produto: " + p.getCodigo() + " nome: " + p.getNome() + " descri��o: " + p.getDescricao() + " pre�o: " + p.getPreco());
        dao.remove(p);

        System.out.println("");

        p = dao.procura(14);
        System.out.println("Atualizando produto: " + p.getCodigo() + " nome: " + p.getNome() + " descri��o: " + p.getDescricao() + " pre�o: " + p.getPreco());
        p.setPreco(20000.56);
        System.out.println("para o novo pre�o " + p.getPreco());
        dao.atualiza(p);

        System.out.println("");

        System.out.println("Listando produtos que tem o seu c�digo at� 20.........");
        List<Produto> produtos = dao.listaProdutosComClausulaWhere();
        for (Produto prod : produtos) {
            System.out.println("Produto: " + prod.getCodigo() + " nome: " + prod.getNome() + " descri��o: " + prod.getDescricao() + " pre�o: " + prod.getPreco());
        }

        System.out.println("");

        System.out.println("Listando produtos utilizando pagina��o de 20 e listando a partir do d�cimo registro.........");
        produtos = dao.listaProdutosPaginacao(10, 20);
        for (Produto prod : produtos) {
            System.out.println("Produto: " + prod.getCodigo() + " nome: " + prod.getNome() + " descri��o: " + prod.getDescricao() + " pre�o: " + prod.getPreco());
        }

        System.out.println("");

        System.out.println("Listando todos os produtos cadastrados.........");
        produtos = dao.listaProdutos();
        for (Produto prod : produtos) {
            System.out.println("Produto: " + prod.getCodigo() + " nome: " + prod.getNome() + " descri��o: " + prod.getDescricao() + " pre�o: " + prod.getPreco());
        }

        System.out.println("");

        System.out.println("Encerrando a conex�o com o banco de dados");
        dao.close();
    }
}
