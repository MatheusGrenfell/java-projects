package view;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.mail.ClienteEmail;

public class Principal {

    public Principal() {
        try {
            aparencia();
            ClienteEmail clienteEmail = new ClienteEmail(getConnection());// Instancia o cliente de e-mail
            clienteEmail.abrirIniciar();// Inicia uma conex�o com o servidor de e-mail
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de conex�o", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // Aplica apar�ncia no programa
    private void aparencia() throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            throw new Exception("O sistema operacional n�o suporta este look and feel");
        }
    }

    // Conecta-se ao banco de dados
    private Connection getConnection() throws Exception {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "systemmail", "key50500");
        } catch (Exception ex) {
            throw new Exception("Erro na conex�o com o banco de dados\nCertifique-se que o oracle est� configurado corretamente nesta m�quina");
        }
    }
}
