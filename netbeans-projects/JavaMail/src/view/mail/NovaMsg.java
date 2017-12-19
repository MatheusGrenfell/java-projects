package view.mail;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Contato;
import model.Mensagem;

import control.ContatosDAO;
import control.DiretorioMsgsDAO;

import view.PanelComponentes;
import view.contatos.ConsultaContatos;
import view.contatos.ListenerContatos;

// Classe para envio de nova mensagem
public class NovaMsg extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField tfPara, tfComCopia, tfComCopiaOculta, tfAssunto;// Remetentes e assunto
    private JComboBox cbAnexo;// Onde est�o o nome dos arquivos que ser�o inseridos em anexo
    private JEditorPane epMensagem;// Onde ser� exibida a mensagem
    private JButton btContatosPara, btContatosCc, btContatosCco, btEnviar,
            btCancelar, btAnexo;// bot�es de consulta, enviar e cancelar, anexos
    private boolean fechado;// Flag utilizado para verificar quando a caixa de
    // di�logo � fechada no bot�o 'X'
    private ContatosDAO contatosDAO;// Conex�es dos contatos com Banco de Dados
    private List<File> anexos;// Lista com os anexos

    public NovaMsg(Frame principal, TipoMsg tipoMsg, Mensagem mensagem,
            Connection con, DiretorioMsgsDAO diretorioMsgsDAO) throws Exception {
        super(principal, true);// Chama o superconstrutor, especificando que essa caixa de di�logo � modal
        contatosDAO = new ContatosDAO(con);// Instancia passando a conex�o
        anexos = new ArrayList<File>();
        initComponents(principal, tipoMsg, mensagem, diretorioMsgsDAO);
        if (tipoMsg != TipoMsg.NOVO && mensagem.getAnexo() != null) {// Se n�o for nova mensagem e tiver anexo adiciona a mensagem
            String[] str = mensagem.getAnexo().split(";");// Separa cada nome de arquivo por ';'
            for (String nomeArq : str) {
                anexos.add(diretorioMsgsDAO.getAnexo(nomeArq));
                cbAnexo.addItem(nomeArq);
            }
            cbAnexo.setSelectedItem(null);
        }
    }

    // Cria os componentes gr�ficos
    private void initComponents(Frame principal, TipoMsg tipoMsg, Mensagem mensagem, DiretorioMsgsDAO diretorioMsgsDAO) throws Exception {
        this.setLayout(null);
        /*Configura t�tulo da caixa de di�logo e obt�m os valores "Para",
        "Assunto", e "Texto" da mensagem com base no tipo de mensagem*/
        String para = "", assunto = "", texto = "";
        boolean flagPara = false;// Flag que identifica se � resposta para uma mensagem
        switch (tipoMsg) {
            // Responde � mensagem
            case RESPONDER:
                this.setTitle("Resposta a mensagem");
                para = mensagem.getEmail();// Obt�m o par�metro "Para" da mensagem
                assunto = mensagem.getAssunto();// Obt�m o assunto da mensagem
                if (!assunto.contains("RES:")) {// Verifica se o assunto n�o cont�m RES: de responder
                    assunto = "RES: " + assunto;
                }
                // Obt�m o conte�do da mensagem.
                texto = diretorioMsgsDAO.getConteudoMsg(mensagem.getCodigo()) + "\n--------- RESPOSTA A MENSAGEM ---------\n";
                flagPara = true;
                break;
            // Encaminha a mensagem
            case ENCAMINHAR:
                this.setTitle("Encaminhar Mensagem");
                assunto = mensagem.getAssunto();// Obt�m o assunto da mensagem
                if (!assunto.contains("ENC:")) {// Verifica se o assunto n�o cont�m ENC: de encaminhar
                    assunto = "ENC: " + assunto;
                }
                // Obt�m o conte�do da mensagem
                texto = diretorioMsgsDAO.getConteudoMsg(mensagem.getCodigo()) + "\n--------- ENCAMINHANDO A MENSAGEM ---------\n";
                break;
            // Nova mensagem
            default:
                this.setTitle("Nova Mensagem");
        }
        PanelComponentes panel = new PanelComponentes(5, 5, 625, 510);
        this.add(panel);

        panel.addJLabel("Para.:", 30, 20, 40, 14);

        tfPara = panel.addJTextField(66, 17, 500, 20);
        tfPara.setText(para);

        btContatosPara = panel.addJButton("...", "Pesquisar contato", 575, 13, 37, 26);
        btContatosPara.addActionListener(this);

        if (flagPara) {
            tfPara.setBackground(Color.WHITE);
            tfPara.setEditable(false);
            btContatosPara.setEnabled(false);
        }

        panel.addJLabel("Cc.:", 40, 50, 40, 14);

        tfComCopia = panel.addJTextField(66, 47, 500, 20);

        btContatosCc = panel.addJButton("...", "Pesquisar contato", 575, 43, 37, 26);
        btContatosCc.addActionListener(this);

        panel.addJLabel("Cco.:", 34, 80, 40, 14);

        tfComCopiaOculta = panel.addJTextField(66, 77, 500, 20);

        btContatosCco = panel.addJButton("...", "Pesquisar contato", 575, 73, 37, 26);
        btContatosCco.addActionListener(this);

        panel.addJLabel("Assunto:", 18, 110, 50, 14);

        tfAssunto = panel.addJTextField(66, 107, 500, 20);
        tfAssunto.setText(assunto);

        btAnexo = panel.addJButton("", "Inserir anexo", 575, 103, 37, 26);
        btAnexo.setIcon(new ImageIcon("Anexo.png"));
        btAnexo.addActionListener(this);

        epMensagem = panel.addJEditorPane(0, 140, 623, 300);
        epMensagem.setText(texto);

        String[] itens = {};
        cbAnexo = panel.addJComboBox(itens, 5, 445, 180, 20);
        cbAnexo.setToolTipText("Anexos atualmente inseridos");

        btEnviar = panel.addJButton("Enviar", "Enviar Mensagem", 225, 460, 70, 26);
        btEnviar.addActionListener(this);

        btCancelar = panel.addJButton("Cancelar", "Limpar os Campos", 335, 460, 70, 26);
        btCancelar.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evento) {
                fechado = true;// Quando fechar no 'X' seta flag para true
            }
        });
        this.setSize(640, 547);
        this.setResizable(false);
        this.setLocationRelativeTo(principal);// Centraliza a caixa de di�logo na aplica��o
    }

    // Atualiza todos os campos para modo original
    private void limparTela() {
        tfPara.setText("");
        tfComCopia.setText("");
        tfComCopiaOculta.setText("");
        tfAssunto.setText("");
        epMensagem.setText("");
        tfPara.setEditable(true);
        btContatosPara.setEnabled(true);
        if (!anexos.isEmpty()) {
            for (int i = 0; i < anexos.size(); i++) {
                anexos.remove(i);
                cbAnexo.removeAllItems();
            }
        }
    }

    // Valida configura��es de conex�o e fecha a caixa de di�logo
    private void enviar() throws Exception {
        if ("".equals(tfPara.getText().trim())) {
            throw new Exception("Campo para obrigat�rio n�o preenchido,\nentre com o endere�o do destinat�rio");
        }
        if ("".equals(tfAssunto.getText().trim())) {
            tfAssunto.setText("[Sem Assunto]");
        }
        if (epMensagem.getText().length() == 110) {// verifica se o campo esta vazio, inicialmente est� com 110 por causa das tags html
            epMensagem.setText("[Sem Mensagem]");
        }
        // Fecha a caixa de di�logo.
        this.dispose();
    }

    // Consulta contatos e exibe conforme o tipo solicitado
    private void consultaContatos(final int tipo) throws Exception {
        if (contatosDAO.isContatoVazio()) {// verifica se h� contatos cadastrados
            throw new Exception("N�o h� contatos cadastrados\nCadastre um contato primeiro");
        }
        ConsultaContatos consulta = new ConsultaContatos(contatosDAO);
        consulta.setListener(new ListenerContatos() {

            @Override
            public void exibeContato(Contato contato) {
                switch (tipo) {
                    case 1:
                        tfPara.setText(contato.getNome() + " <" + contato.getEmail() + ">");
                        break;
                    case 2:
                        if ("".equals(tfComCopia.getText().trim())) {
                            tfComCopia.setText(contato.getNome() + " <" + contato.getEmail() + ">");
                        } else {
                            tfComCopia.setText(tfComCopia.getText() + "; " + contato.getNome() + " <" + contato.getEmail() + ">");
                        }
                        break;
                    default:
                        if ("".equals(tfComCopiaOculta.getText().trim())) {
                            tfComCopiaOculta.setText(contato.getNome() + " <" + contato.getEmail() + ">");
                        } else {
                            tfComCopiaOculta.setText(tfComCopiaOculta.getText() + "; " + contato.getNome() + " <" + contato.getEmail() + ">");
                        }
                        break;
                }
            }
        });
        consulta.setModal(true);
        consulta.setVisible(true);
    }

    // Abre o seletor de arquivos
    private void anexarArquivo() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File arq = fileChooser.getSelectedFile();// Ob�m o arquivo selecionado
            anexos.add(arq);// Adiciona na lista
            cbAnexo.addItem(arq.getName());// adiciona o nome do arquivo no combo box de anexos
        }
    }

    // Obt�m a lista com os anexos
    public List<File> getListaAnexos() {
        return anexos;
    }

    // Verifica se a lista de anexos est� vazia
    public boolean isListaAnexosVazio() {
        return anexos.isEmpty();
    }

    // Obt�m verdadeiro se a caixa de di�logo foi fechada
    public boolean isFechado() {
        return fechado;
    }

    // Obt�m o valor do campo "para" da mensagem
    public String getPara() {
        return tfPara.getText();
    }

    // Obt�m o valor do campo "cc" da mensagem
    public String getCc() {
        return tfComCopia.getText();
    }

    // Obt�m o valor do campo "cco" da mensagem
    public String getCco() {
        return tfComCopiaOculta.getText();
    }

    // Obt�m o assunto da mensagem
    public String getAssunto() {
        return tfAssunto.getText();
    }

    // Obt�m a mensagem
    public String getMsg() {
        return epMensagem.getText();
    }

    // Trata eventos
    @Override
    public void actionPerformed(ActionEvent evento) {
        // Valida configura��es de conex�o e fecha a caixa de di�logo
        if (evento.getSource() == btEnviar) {
            try {
                enviar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Atualiza todos os campos para modo original
        if (evento.getSource() == btCancelar) {
            limparTela();
        }
        // Consulta contatos do tipo para
        if (evento.getSource() == btContatosPara) {
            try {
                consultaContatos(1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Consulta contatos do tipo com c�pia
        if (evento.getSource() == btContatosCc) {
            try {
                consultaContatos(2);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Consulta contatos do tipo com c�pia oculta
        if (evento.getSource() == btContatosCco) {
            try {
                consultaContatos(3);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Consulta contatos do tipo com c�pia oculta
        if (evento.getSource() == btAnexo) {
            try {
                anexarArquivo();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
