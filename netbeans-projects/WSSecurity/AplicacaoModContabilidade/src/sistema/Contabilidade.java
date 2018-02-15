package sistema;

import br.client.middleware.MiddlewareWSS;
import br.client.middleware.action.dados.ArquivoDados;

/*
 * Document   : Contabilidade.java
 * Created on : 23/11/2013, 15:21:42
 * Author     : Caio
 */
public class Contabilidade {

    public static void main(String[] args) {
        try {

            //Cria��o de uma �nica inst�ncia do middleware durante toda execu��o
            MiddlewareWSS middlewareWSS = MiddlewareWSS.getInstancie();

            //Configura��es iniciais
            middlewareWSS.setNrSeqSistema(210);//Sequ�ncia da aplica��o Contabilidade cadastrada
            middlewareWSS.setDirRecebimentoArquivos("C:\\Arquivos\\Contabilidade\\");//Diret�rio para recebimento de arquivos
            middlewareWSS.configurarMiddleware();//Cria uma conex�o com o web service

            //Credenciais do usu�rio que ir� realizar a comunica��o
            middlewareWSS.setUser("ucontabilidade", "87654321");

            //Recebe uma requisi��o do servidor no formato xml
            System.out.println(middlewareWSS.receberRequisicao());

            //Recebe um arquivo do servidor
            ArquivoDados arq = middlewareWSS.receberArquivo();
            System.out.println(arq.getNmUsuario());
            System.out.println(arq.getCdRegra());
            System.out.println(arq.getCdPermissao());
            System.out.println(arq.getArquivo().getPath());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}