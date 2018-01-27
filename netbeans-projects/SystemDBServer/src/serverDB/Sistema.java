package serverDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sistema {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "systemdb", "key50400");

            new Servidor(con);

        } catch (Exception ex) {
            System.err.print("N�o foi possivel estabelecer uma conex�o com o banco de dados");
        }
    }
}
