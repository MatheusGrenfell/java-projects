package Excecao;

public class ExceptionNumber extends Exception {

    private static final long serialVersionUID = 1L;

    public ExceptionNumber() {
        super("Entre com um n�mero v�lido");
    }

    public ExceptionNumber(String mensagem) {
        super(mensagem);
    }
}
