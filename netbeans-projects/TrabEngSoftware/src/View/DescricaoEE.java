package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoEE extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoEE() {
        setTitle("Entrada Externa EE");
        JTextArea textArea = new JTextArea("PE (Processo Elementar, que � a menor unidade de atividade"
                + "\nsignificativa para o usu�rio) que processa dados e/ou"
                + "\ninforna��es de controle vindos de fora da froteira da aplica��o."
                + "\nSua principal inten��o � manter um ou mais ALIs e/ou alterar"
                + "\no comportamento dos sistema.");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 150);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
