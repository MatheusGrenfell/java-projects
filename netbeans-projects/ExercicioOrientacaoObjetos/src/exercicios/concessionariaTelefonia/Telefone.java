package exercicios.concessionariaTelefonia;

import java.util.Date;

public abstract class Telefone {

    protected String nomeUsuario;
    protected String numero;
    protected Date dataInstalacao;
    protected String enderecoInstalacao;

    public Telefone(String nomeUsuario, String numero, Date dataInstalacao, String enderecoInstalacao) {
        setNomeUsuario(nomeUsuario);
        setNumero(numero);
        setDataInstalacao(dataInstalacao);
        setEnderecoInstalacao(enderecoInstalacao);
    }

    public abstract float getValorBasico();

    public abstract String exibirDados();

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        if (nomeUsuario == null || nomeUsuario.isEmpty()) {
            throw new IllegalArgumentException("Nome de usu�rio inv�lido");
        }
        this.nomeUsuario = nomeUsuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.length() < 8) {
            throw new IllegalArgumentException("N�mero do telefone inv�lido");
        }
        this.numero = numero;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        if (dataInstalacao == null) {
            throw new IllegalArgumentException("Data de instala��o inv�lida");
        }
        this.dataInstalacao = dataInstalacao;
    }

    public String getEnderecoInstalacao() {
        return enderecoInstalacao;
    }

    public void setEnderecoInstalacao(String enderecoInstalacao) {
        if (enderecoInstalacao == null || enderecoInstalacao.isEmpty()) {
            throw new IllegalArgumentException("Endere�o de instala��o inv�lido");
        }
        this.enderecoInstalacao = enderecoInstalacao;
    }
}
