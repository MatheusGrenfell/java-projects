package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.MimeMultipart;

public class DiretorioMsgsDAO {

    // Obt�m o conte�do de uma mensagem
    public List<String> gravarMsg(Message mensagem, int codigoMsg) throws Exception {
        List<String> nomeAnexo = new ArrayList<String>();
        StringBuffer conteudoMsg = new StringBuffer();
        Object conteudo = mensagem.getContent();// Obt�m o conte�do da mensagem
        if (conteudo instanceof MimeMultipart) {/*Verifica se a mensagem � multiparte ou n�o. Se for o m�todo getContent() retornar�
            um objeto Multipart. Multipart encapsula uma lista de partes para uma mensagem multipart*/
            MimeMultipart mimeMultipartMsg = (MimeMultipart) conteudo;// Multiparte da mensagem
            String descricao;// Descri��o para verifica��o se h� anexo
            BodyPart bodyPart, bodyPartInterna;// bodyPart = parte da mensagem, bodyPartInterna parte da multiparte da parte da mensagem
            MimeMultipart mimeMultipartPart;// Multiparte de uma parte, se houver
            Object conteudoParte;// Conte�do de uma parte da mensagem
            for (int i = 0; i < mimeMultipartMsg.getCount(); i++) {/*Itera por cada parte da mensagem para localizar e extrair 
                as partes do conte�do da mensagem*/
                bodyPart = mimeMultipartMsg.getBodyPart(i);// Obt�m a parte da mensagem
                descricao = bodyPart.getDisposition();// Obt�m a descri��o da parte
                if (descricao != null && descricao.equals(BodyPart.ATTACHMENT)) {// Verifica se h� anexo nesta parte
                    nomeAnexo.add(salvarAnexo(bodyPart));// se houver salva o anexo
                } else {
                    if (bodyPart.isMimeType("text/html")) {// Verifica se a parte � html
                        conteudoMsg.append(bodyPart.getContent().toString());
                    } else {
                        conteudoParte = bodyPart.getContent();// Obt�m o conte�do de uma parte da mensagem
                        if (conteudoParte instanceof MimeMultipart) {// Verifica se a parte do conte�do � multiparte ou n�o. Se for o m�todo getContent() retornar� um objeto Multipart
                            mimeMultipartPart = (MimeMultipart) bodyPart.getContent();
                            for (int y = 0; y < mimeMultipartPart.getCount(); y++) {/*Itera por cada parte da parte de uma mensagem 
                                para localizar e extrair as partes do conte�do da mensagem*/
                                bodyPartInterna = mimeMultipartPart.getBodyPart(y);
                                if (bodyPartInterna.isMimeType("text/html")) {// Verifica se a parte � html
                                    conteudoMsg.append(bodyPartInterna.getContent().toString());
                                }
                            }
                        }
                    }
                }
            }
        } else {
            conteudoMsg.append(conteudo.toString());
        }
        if ("".equals(conteudoMsg)) {
            conteudoMsg.append("[Sem Mensagem]");
        }
        gravarConteudoMsg(conteudoMsg, codigoMsg);
        return nomeAnexo;
    }

    // Salva mensagem por bytes no arquivo
    private String salvarAnexo(BodyPart bodyPart) throws Exception {
        File diretorio = new File("Anexos");
        if (diretorio.mkdir() || diretorio.exists()) {// Cria um diret�rio que retorna true se criou e verifica se diret�rio existe
            try {
                InputStream in = bodyPart.getInputStream();
                FileOutputStream out = new FileOutputStream(new File(diretorio, bodyPart.getFileName()));
                int b;
                while ((b = in.read()) > -1) {
                    out.write(b);
                }
                in.close();
                out.close();
                return bodyPart.getFileName();
            } catch (Exception ex) {
                throw new Exception("Erro ao salvar o anexo");
            }
        }
        throw new Exception("N�o � pos�vel salvar o anexo");
    }

    // Abre um anexo
    public void abrirAnexo(String nomearq) throws Exception {
        File arquivo = new File("Anexos/" + nomearq);
        if (arquivo.exists()) {// Se arquivo existe
            Runtime.getRuntime().exec("cmd.exe /c \"" + arquivo.getAbsolutePath() + "\"");// Abre o arquivo
            return;
        }
        throw new Exception("Arquivo n�o encontrado\nEle pode ter sido removido");
    }

    public void deleteAnexo(String nomearq) throws Exception {
        File diretorio = new File("Anexos");
        if (diretorio.exists()) {
            File arquivo = new File(diretorio, nomearq);
            if (arquivo.exists()) {
                arquivo.delete();
            }
        }
    }

    // Obt�m um anexo
    public File getAnexo(String nomearq) throws Exception {
        File diretorio = new File("Anexos");
        if (diretorio.exists()) {
            File arquivo = new File(diretorio, nomearq);
            if (arquivo.exists()) {
                return arquivo;
            }
            throw new Exception("Anexo n�o encontrado\nEle pode ter sido removido");
        }
        throw new Exception("Diretorio n�o encontrado\nEle pode ter sido removido");
    }

    // Grava mensagem no arquivo
    private void gravarConteudoMsg(StringBuffer conteudoMsg, int codigoMsg) throws Exception {
        File diretorio = new File("Mensagens");
        if (diretorio.mkdir() || diretorio.exists()) {// Cria um diret�rio que retorna true se criou e verifica se diret�rio existe
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(diretorio, codigoMsg + ".txt"))));
                out.println(conteudoMsg);
                out.close();
                return;
            } catch (IOException ex) {
                throw new Exception("Erro ao gravar a mensagem no arquivo");
            }
        }
        throw new Exception("N�o � pos�vel salvar a mensagem no arquivo");
    }

    // Leitura do conte�do do arquivo
    public StringBuffer getConteudoMsg(int codigoMsg) throws Exception {
        File diretorio = new File("Mensagens");
        if (diretorio.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(new File(diretorio, codigoMsg + ".txt")));
                try {
                    StringBuffer conteudoMsg = new StringBuffer();
                    while (in.ready()) {
                        conteudoMsg.append(in.readLine());
                    }
                    in.close();
                    return conteudoMsg;
                } catch (IOException ex) {
                    throw new Exception("Erro na leitura da mensagem no arquivo");
                }
            } catch (FileNotFoundException ex) {
                throw new Exception("Arquivo n�o encontrado\nEle pode ter sido removido");
            }
        }
        throw new Exception("Diret�rio n�o encontrado\nEle pode ter sido removido");
    }

    public void deleteMsg(int codigoMsg) throws Exception {
        File diretorio = new File("Mensagens");
        if (diretorio.exists()) {
            File arquivo = new File(diretorio, codigoMsg + ".txt");
            if (arquivo.exists()) {
                arquivo.delete();
                return;
            }
            throw new Exception("Arquivo n�o encontrado\nEle pode j� pode ter sido removido");
        }
        throw new Exception("Diret�rio n�o encontrado\nEle pode j� pode ter sido removido");
    }
}
