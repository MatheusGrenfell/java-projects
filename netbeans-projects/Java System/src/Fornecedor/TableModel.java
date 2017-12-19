package Fornecedor;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private FornecedorControl controle;

    public TableModel(FornecedorControl controle) {
        this.controle = controle;
        try {
            this.controle.listaTodos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int getColumnCount() {
        return 26;
    }

    @Override
    public int getRowCount() {
        return controle.getQtdadeFornCadas();
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
                return "Inscri��o Estadual";
            case 3:
                return "CNPJ";
            case 4:
                return "Inscri��o Municipal";
            case 5:
                return "Tipo Fornecedor";
            case 6:
                return "Endere�o";
            case 7:
                return "Bairro";
            case 8:
                return "Numero";
            case 9:
                return "Cidade";
            case 10:
                return "Estado";
            case 11:
                return "Regi�o";
            case 12:
                return "Fone";
            case 13:
                return "Celular";
            case 14:
                return "E-Mail";
            case 15:
                return "MSN";
            case 16:
                return "Descri��o";
            case 17:
                return "Comiss�o";
            case 18:
                return "Compra M�nima";
            case 19:
                return "Compra M�xima";
            case 20:
                return "Valor Frete";
            case 21:
                return "ICMS";
            case 22:
                return "Cofins";
            case 23:
                return "IPI";
            case 24:
                return "Juros a.m.";
            default:
                return "Descontos";
        }
    }
}
