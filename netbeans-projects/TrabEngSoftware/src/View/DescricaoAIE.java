package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoAIE extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoAIE() {
        setTitle("Arquivos de Interface Externa AIE");
        JTextArea textArea = new JTextArea("Grupo de dados ou informa��es de controle logicamente"
                + "\nrelacionado, reconhecido pelo usu�rio, referenciado pela"
                + "\naplica��o mas mantido na fronteira de outra. Sua principal"
                + "\ninten��o � armazenar dados referenciados por um ou mais"
                + "\nPEs (Processo Elementar, que � a menor unidade de atividade"
                + "\nsignificativa para o usu�rio) da alica��o sendo contada. O AIE"
                + "\ncontado para a aplica��o deve ser um ALI para outra aplica��o.");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 170);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
