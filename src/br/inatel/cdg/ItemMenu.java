package br.inatel.cdg;

public abstract class ItemMenu {
    
    protected java.lang.String nome;
  
  protected double preco;
  
  public ItemMenu(java.lang.String nome, double preco) {
  }
  
  public java.lang.String getNome() {
    return null;
  }
  
  public double getPreco() {
    return 0;
  }
  
  public abstract java.lang.String getCategoria();
  
  public void exibirDetalhes() {
  }
}
