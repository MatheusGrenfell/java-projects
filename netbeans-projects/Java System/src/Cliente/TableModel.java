package Cliente;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private ClienteControl controle;

    public TableModel(ClienteControl controle) {
        this.controle = controle;
        try {
            this.controle.listaTodos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int getColumnCount() {
        return 19;
    }

    @Override
    public int getRowCount() {
        return controle.getQtdadeClieCadas();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        return controle.conteudoTableModel(linha, coluna);
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Codigo";
            case 1:
                return "Nome";
            case 2:
                return "RG";
            case 3:
                return "CPF";
            case 4:
                return "Profiss�o";
            case 5:
                return "Empresa";
            case 6:
                return "Fone Empresa";
            case 7:
                return "Sexo";
            case 8:
                return "CEP";
            case 9:
                return "Endere�o";
            case 10:
                return "Bairro";
            case 11:
                return "Numero";
            case 12:
                return "Complemento";
            case 13:
                return "Cidade";
            case 14:
                return "Estado";
            case 15:
                return "Fone";
            case 16:
                return "Celular";
            case 17:
                return "E-Mail";
            default:
                return "Descri��o";
        }
    }
}
