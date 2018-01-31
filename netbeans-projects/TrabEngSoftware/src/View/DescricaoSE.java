package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoSE extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoSE() {
        setTitle("Sa�da Externa SE");
        JTextArea textArea = new JTextArea("Gera dados ou informa��es de controle que saem pela"
                + "\nfronteira da aplica��o. Sua principal inten��o � apresentar"
                + "\ndados ao usu�rio com outra l�gica que n�o s� a sua simples"
                + "\nrecupera��o. Deve conter f�rmula matem�tica ou c�lculo,"
                + "\ncriar dados derivados, manter um ou mais ALI e/ou alterar"
                + "\no comportamento do sistema.");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 150);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
