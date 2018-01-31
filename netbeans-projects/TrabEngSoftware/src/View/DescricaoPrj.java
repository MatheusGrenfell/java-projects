package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoPrj extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoPrj() {
        setTitle("Projeto de Melhoria");
        JTextArea textArea = new JTextArea("Projeto para desenvolver e entregar manuten��o adaptativa."
                + "\nSeu tamanho funcional � a medida das fun��es inclu�das,"
                + "\nalteradas ou exclu�das ao final do projeto, como medido pela"
                + "\ncontagem de pontos de fun��o de projeto de melhoria.");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 130);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
