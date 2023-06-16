package br.inatel.cdg;

import java.io.PrintStream;

abstract class ItemMenu {
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
        PrintStream var10000 = System.out;
        String var10001 = this.getCategoria();
        var10000.println(var10001 + ": " + this.nome);
        System.out.println("Preço: R$" + this.preco);
    }
}