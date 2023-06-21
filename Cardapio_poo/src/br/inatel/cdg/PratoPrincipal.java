package br.inatel.cdg;

public class PratoPrincipal extends ItemMenu {
    private final String descricao;

    public PratoPrincipal(String nome, double preco, String descricao) {
        super(nome, preco);
        this.descricao = descricao;
    }

    @Override
    public String getCategoria() {
        return "Prato Principal";
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Descrição: " + descricao);
        System.out.println();
    }
}
