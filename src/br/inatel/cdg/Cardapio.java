package br.inatel.cdg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Cardapio {
    private List<ItemMenu> itens = new ArrayList();

    public Cardapio() {
    }

    public void adicionarItem(ItemMenu item) {
        this.itens.add(item);
    }

    public void exibirCardapio() {
        System.out.println("Cardápio do Restaurante:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        Iterator var1 = this.itens.iterator();

        while(var1.hasNext()) {
            ItemMenu item = (ItemMenu)var1.next();
            item.exibirDetalhes();
        }

    }

    public ItemMenu buscarItem(String nome) {
        Iterator var2 = this.itens.iterator();

        while(var2.hasNext()) {
            ItemMenu item = (ItemMenu)var2.next();
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }

        return null;
    }
}