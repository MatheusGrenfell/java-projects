package Exe3;

import java.util.ArrayList;
import java.util.List;

public class Lanchonete {

    private List<ItemPedido> lista = new ArrayList<ItemPedido>();

    public void addPedido(ItemPedido itemPedido) {
        lista.add(itemPedido);
    }

    public String getPedido() {
        if (lista.isEmpty()) {
            return "N�o h� itens cadastrados";
        }
        String pedido = "N� Pedido\tPedido: Valor\n";
        for (ItemPedido item : lista) {
            pedido += item.getNumItem() + "\t\t" + item.getItem() + " : R$ " + item.getValor() + "\n";
        }
        return pedido;
    }

    public String getItemPedido(int numItem, double pagamento) {
        for (ItemPedido item : lista) {
            if (numItem == item.getNumItem()) {
                if (pagamento < item.getValor()) {
                    return "Valor pago abaixo do valor do pedido";
                }
                return "N�mero Item: " + item.getNumItem() + "\nItem: "
                        + item.getItem() + "\nValor: " + item.getValor()
                        + "\nTroco Fornecido: " + (pagamento - item.getValor());
            }
        }
        return "N�mero do pedido inv�lido";
    }
}
