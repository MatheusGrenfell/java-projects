package sistema;

import br.client.middleware.MiddlewareWSS;
import br.client.middleware.action.dados.Lista;
import br.client.middleware.action.dados.Registro;
import java.io.File;

/*
 * Document   : Faturamento.java
 * Created on : 23/11/2013, 15:18:58
 * Author     : Caio
 */
public class Faturamento {

    public static void main(String[] args) {
        try {

            //Cria��o de uma �nica inst�ncia do middleware durante toda execu��o
            MiddlewareWSS middlewareWSS = MiddlewareWSS.getInstancie();

            //Configura��es iniciais
            middlewareWSS.setNrSeqSistema(20);//Sequ�ncia da aplica��o Faturamento cadastrada
            middlewareWSS.configurarMiddleware();//Cria uma conex�o com o web service

            //Credenciais do usu�rio que ir� realizar a comunica��o
            middlewareWSS.setUser("ufaturamento", "12345678");

            //Cria��o de uma lista contendo 2 registros
            Lista lista = new Lista();

            Registro registro = new Registro();
            registro.addInfo("NR_SEQUENCIA", 1);
            registro.addInfo("VL_TOTAL", 1300.87);
            lista.addRegistro(registro);

            registro = new Registro();
            registro.addInfo("NR_SEQUENCIA", 2);
            registro.addInfo("VL_TOTAL", 7654.7);
            lista.addRegistro(registro);

            //Envia a requisi��o - informando o sistema destinat�rio, o c�digo da regra e o c�digo da permiss�o
            System.out.println(middlewareWSS.enviarRequisicao(lista, 210, "BNCDSH654JSD", "HYTFV8633456"));

            System.out.println("");

            //Envia um arquivo - informando o sistema destinat�rio, o c�digo da regra e o c�digo da permiss�o
            System.out.println(middlewareWSS.enviarArquivo(new File("C:\\Users\\Caio\\Documents\\Arquivos\\Downloads\\GWT.pdf"), 210, "76XSHDFUDE65", "JSUS7624FT5J"));

            System.out.println("");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
