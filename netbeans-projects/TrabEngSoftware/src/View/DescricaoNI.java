package View;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DescricaoNI extends JDialog {

    private static final long serialVersionUID = 1L;

    public DescricaoNI() {
        setTitle("N�vel de Influ�ncia NI");
        JTextArea textArea = new JTextArea("O FA (Fator de Ajuste) � baseado em 14 caracter�sticas gerais"
                + "\nde sistema que determina a funcionalidade geral da aplica��o"
                + "\nque est� sendo contada. O n�vel (grau) de influ�ncia varia em"
                + "\numa escala de 0 a 5."
                + "\n0 - Nenhuma influ�ncia"
                + "\n1 - Influ�ncia m�nima"
                + "\n2 - Influ�ncia moderada"
                + "\n3 - Influ�ncia m�dia"
                + "\n4 - Influ�ncia significante"
                + "\n5 - Influ�ncia forte");
        textArea.setEditable(false);
        add(textArea);
        setSize(370, 210);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
