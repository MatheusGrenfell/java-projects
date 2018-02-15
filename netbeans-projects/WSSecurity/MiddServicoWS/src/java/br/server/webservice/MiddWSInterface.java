package br.server.webservice;

/*
 * Document   : MiddWSInterface.java
 * Created on : 19/09/2013, 19:38:21
 * Author     : Caio
 */
import br.server.action.Arquivo;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MiddWSInterface {

    /**
     * Enviar uma requisi��o ao servidor
     *
     * @param nmUsuario - usu�rio que est� realizando a requisi��o
     * @param nrSeqSistemaOrigem - sistema que est� enviando a requisi��o
     * @param nrSeqSistemaDestino - sistema na qual ser� enviada a requisi��o
     * @param requisicao - xml contendo a requisi��o
     * @param cdRegra - regra utilizada na comunica��o
     * @param cdPermissao - opera��o a ser realizada com esta requisi��o
     *
     * @exception - lan�a exce��o caso ocorra alguma falha na comunica��o, ou se
     * o usu�rio n�o possua permiss�o
     *
     * @return - se a requisi��o foi bem sucedida
     */
    @WebMethod(operationName = "enviarRequisicao")
    public String enviarRequisicao(@WebParam(name = "nmUsuario") String nmUsuario,
            @WebParam(name = "nrSeqSistemaOrigem") long nrSeqSistemaOrigem,
            @WebParam(name = "nrSeqSistemaDestino") long nrSeqSistemaDestino,
            @WebParam(name = "requisicao") String requisicao,
            @WebParam(name = "cdRegra") String cdRegra,
            @WebParam(name = "cdPermissao") String cdPermissao) throws Exception;

    /**
     * Obt�m a requisi��o enviada ao servidor
     *
     * @param nrSeqSistema - sistema na qual receber� a requisi��o
     *
     * @exception - lan�a exce��o caso ocorra alguma falha na comunica��o
     *
     * @return - requisi��o
     */
    @WebMethod(operationName = "receberRequisicao")
    public String receberRequisicao(@WebParam(name = "nrSeqSistema") long nrSeqSistema) throws Exception;

    /**
     * Enviar um arquivo ao servidor
     *
     * @param nmUsuario - usu�rio que est� enviando o arquivo
     * @param nrSeqSistemaOrigem - sistema que est� enviando o arquivo
     * @param nrSeqSistemaDestino - sistema na qual ser� enviado o arquivo
     * @param arquivo - arquivo de dados
     * @param cdRegra - regra utilizada na comunica��o
     * @param cdPermissao - opera��o a ser realizada com este erquivo
     *
     * @exception - lan�a exce��o caso ocorra alguma falha na comunica��o, ou se
     * o usu�rio n�o possua permiss�o
     *
     * @return - se o arquivo foi enviado com sucesso
     */
    @WebMethod(operationName = "enviarArquivo")
    public String enviarArquivo(@WebParam(name = "nmUsuario") String nmUsuario,
            @WebParam(name = "nrSeqSistemaOrigem") long nrSeqSistemaOrigem,
            @WebParam(name = "nrSeqSistemaDestino") long nrSeqSistemaDestino,
            @WebParam(name = "arquivo") Arquivo arquivo,
            @WebParam(name = "cdRegra") String cdRegra,
            @WebParam(name = "cdPermissao") String cdPermissao) throws Exception;

    /**
     * Obt�m o arquivo enviado ao servidor
     *
     * @param nrSeqSistema - sistema na qual receber� o arquivo
     *
     * @exception - lan�a exce��o caso ocorra alguma falha na comunica��o
     *
     * @return - arquivos de dados
     */
    @WebMethod(operationName = "receberArquivo")
    public Arquivo receberArquivo(@WebParam(name = "nrSeqSistema") long nrSeqSistema) throws Exception;

    /**
     * Remove o arquivo na qual foi consumido pelo middleware
     *
     * @param dsArquivo - diret�rio do arquivo no servidor
     *
     * @exception - lan�a exce��o caso ocorra alguma falha na comunica��o
     */
    @WebMethod(operationName = "removerArquivoServidor")
    public void removerArquivoServidor(@WebParam(name = "dsArquivo") String dsArquivo) throws Exception;
}