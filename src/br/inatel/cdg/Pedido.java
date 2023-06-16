package br.inatel.cdg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Pedido {
    private final List<ItemMenu> itens = new ArrayList();
    private double total = 0.0;

    public Pedido() {
    }

    public void adicionarItem(ItemMenu item) {
        this.itens.add(item);
        this.total += item.getPreco();
    }

    public void exibirPedido() {
        System.out.println("Pedido do Cliente:");
        System.out.println("------------------");
        if (this.itens.isEmpty()) {
            System.out.println("Nenhum item foi adicionado ao pedido.");
        } else {
            Iterator var1 = this.itens.iterator();

            while(var1.hasNext()) {
                ItemMenu item = (ItemMenu)var1.next();
                item.exibirDetalhes();
            }

            System.out.println("Total: R$" + this.total);
        }

    }

    public void salvarPedidoEmArquivo(String nomeArquivo) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));

            try {
                Iterator<ItemMenu> var3 = this.itens.iterator();

                while(var3.hasNext()) {
                    ItemMenu item = (ItemMenu)var3.next();
                    writer.println(item.getNome());
                    writer.println(item.getPreco());
                }

                writer.println("Total:" + this.total);
                System.out.println("Pedido salvo em " + nomeArquivo);
            } catch (Throwable var6) {
                try {
                    writer.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            writer.close();
        } catch (IOException var7) {
            System.out.println("Erro ao salvar o pedido: " + var7.getMessage());
        }

    }

    public void carregarPedidoDeArquivo(String nomeArquivo) {
        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));

            double preco;
            try {
                for(; scanner.hasNextLine(); this.total += preco) {
                    String linha = scanner.nextLine();
                    System.out.println(linha);
                    if (linha.contains("Total:")) {
                        System.out.println("Pedido carregado de " + nomeArquivo);
                        break;
                    }

                    preco = Double.parseDouble(scanner.nextLine());
                    String categoria = scanner.nextLine();
                    String descricao = "";
                    if (categoria.equals("Entradas")) {
                        descricao = scanner.nextLine();
                        ItemMenu item = new Entradas(linha, preco, descricao);
                        this.itens.add(item);
                    } else if (categoria.equals("Prato Principal")) {
                        descricao = scanner.nextLine();
                        ItemMenu item = new PratoPrincipal(linha, preco, descricao);
                        this.itens.add(item);
                    } else if (categoria.equals("Bebida")) {
                        boolean alcoolica = Boolean.parseBoolean(scanner.nextLine());
                        descricao = scanner.nextLine();
                        ItemMenu item = new Bebida(linha, preco, alcoolica, descricao);
                        this.itens.add(item);
                    }
                }
            } catch (Throwable var12) {
                try {
                    scanner.close();
                } catch (Throwable var11) {
                    var12.addSuppressed(var11);
                }

                throw var12;
            }

            scanner.close();
        } catch (FileNotFoundException var13) {
            System.out.println("Arquivo não encontrado: " + var13.getMessage());
        } catch (NumberFormatException var14) {
            System.out.println("Erro ao ler o preço do item: " + var14.getMessage());
        }

    }
}