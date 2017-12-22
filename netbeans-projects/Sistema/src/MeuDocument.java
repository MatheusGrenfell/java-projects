
import javax.swing.text.*;

//Este Habilita para digitar apenas numeros e não letras nos campos
public class MeuDocument extends PlainDocument {

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        char digito;
        boolean numerico = true;

        for (int i = 0; i < str.length(); i++) {
            digito = str.charAt(i);

            if (!Character.isDigit(digito)) {
                numerico = false;
                break;
            }
        }

        if (numerico) {
            super.insertString(offs, str, a);
        }
    }
}
