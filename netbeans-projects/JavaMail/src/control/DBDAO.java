package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBDAO {

    private Connection con;

    public DBDAO(Connection con) {
        this.con = con;
    }

    // Verifica se est� cadastrado e obt�m a chave, caso contr�rio retorna -1 indicando que n�o est� cadastrado
    protected int getCadastrado(String sql, String msg) throws SQLException {
        ResultSet rs = null;
        try {
            rs = con.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            throw new SQLException(msg);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }

    // Se est� cadastrado e retorna verdadeiro
    protected boolean isCadastrado(String sql, String msg) throws SQLException {
        ResultSet rs = null;
        try {
            rs = con.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw new SQLException(msg);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }

    // Verifica se tabela est� vazia
    protected boolean isVazio(String sql, String msg) throws SQLException {
        ResultSet rs = null;
        try {
            rs = con.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
            return true;
        } catch (SQLException ex) {
            throw new SQLException(msg);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }

    // Obt�m o pr�ximo c�digo dispon�vel
    protected int getProxCod(String sql, String msg) throws SQLException {
        ResultSet rs = null;
        try {
            rs = con.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
            return 1;
        } catch (SQLException ex) {
            throw new SQLException(msg);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }

    // Exclui um registro da tabela e retorna verdadeiro em caso de sucesso
    protected boolean delete(String sql, String msg) throws SQLException {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            return stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw new SQLException(msg);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
            }
        }
    }
}
