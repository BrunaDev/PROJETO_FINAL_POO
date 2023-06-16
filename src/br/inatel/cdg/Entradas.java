package br.inatel.cdg;

class Entradas extends ItemMenu {
    private String descricao;

    public Entradas(String nome, double preco, String descricao) {
        super(nome, preco);
        this.descricao = descricao;
    }

    public String getCategoria() {
        return "Entrada";
    }

    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Descrição: " + this.descricao);
        System.out.println();
    }
}