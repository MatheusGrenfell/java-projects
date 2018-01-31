package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoCE extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoCE() {
        setTitle("Consulta Externa CE");
        JTextArea textArea = new JTextArea("Recupera��o de dados ou informa��es de controle, enviados"
                + "\npara fora da fronteira da aplica��o. Sua principal inten��o �"
                + "\napresentar informa��es ao usu�rio pela simples recupera��o"
                + "\nde dados ou informa��es de controle de um ALIs/AIEs.");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 140);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
