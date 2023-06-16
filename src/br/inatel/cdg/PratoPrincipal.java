package br.inatel.cdg;

class PratoPrincipal extends ItemMenu {
    private final String descricao;

    public PratoPrincipal(String nome, double preco, String descricao) {
        super(nome, preco);
        this.descricao = descricao;
    }

    public String getCategoria() {
        return "Prato Principal";
    }

    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Descrição: " + this.descricao);
        System.out.println();
    }
}