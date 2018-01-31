package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoALI extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoALI() {
        setTitle("Arquivo L�gico Interno ALI");
        JTextArea textArea = new JTextArea("Grupo de dados ou informa��es de controle logicamente"
                + "\nrelacionado, mantido na fronteira da aplica��o e recohlecido"
                + "\npelo usu�rio. A principal inten��o de um ALI � armazenar"
                + "\ndados mantidos por um ou mais processos elementares"
                + "\nda aplica��o sendo contada.");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 150);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
