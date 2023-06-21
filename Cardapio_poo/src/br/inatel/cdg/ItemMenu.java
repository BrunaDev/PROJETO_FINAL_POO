package br.inatel.cdg;

public abstract class ItemMenu {
    protected String nome;
    protected double preco;

    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public abstract String getCategoria();

    public void exibirDetalhes() {
        System.out.println(getCategoria() + ": " + nome);
        System.out.println("Preço: R$" + preco);
    }
}