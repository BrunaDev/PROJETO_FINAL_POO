package br.inatel.cdg;

import java.io.PrintStream;

class Bebida extends ItemMenu {
    private boolean alcoolica;
    private String descricao;

    public Bebida(String nome, double preco, boolean alcoolica, String descricao) {
        super(nome, preco);
        this.alcoolica = alcoolica;
        this.descricao = descricao;
    }

    public String getCategoria() {
        return "Bebida";
    }

    public void exibirDetalhes() {
        PrintStream var10000 = System.out;
        String var10001 = this.getCategoria();
        var10000.println(var10001 + ": " + this.nome);
        double var1 = this.preco;
        System.out.println("Preço: R$" + var1);
        System.out.println("Alcoólica: " + (this.alcoolica ? "Sim" : "Não"));
        System.out.println("Descrição: " + this.descricao);
        System.out.println();
    }
}
