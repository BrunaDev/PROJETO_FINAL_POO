package br.inatel.cdg;

public class Entradas extends ItemMenu {
    private String descricao;

    public Entradas(String nome, double preco, String descricao) {
        super(nome, preco);
        this.descricao = descricao;
    }

    @Override
    public String getCategoria() {
        return "Entrada";
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Descrição: " + descricao);
        System.out.println();
    }
}
