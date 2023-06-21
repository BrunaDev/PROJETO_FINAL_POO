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

public class Pedido {
    private final List<ItemMenu> itens = new ArrayList<>();
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
            for (ItemMenu item : this.itens) {
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

                while (true) {
                    if (!var3.hasNext()) {
                        writer.println("Total:" + this.total);
                        System.out.println("Pedido salvo em " + nomeArquivo);
                        break;
                    }

                    ItemMenu item = var3.next();
                    writer.println(item.getNome());
                    writer.println(item.getPreco());
                }
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

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if (linha.contains("Total:")) {
                    System.out.println("Pedido carregado de " + nomeArquivo);
                    break;
                }

                String nome = linha;
                double preco = Double.parseDouble(scanner.nextLine());

                String categoria = scanner.nextLine();
                String descricao = "";

                if (categoria.equals("Entrada")) {
                    descricao = scanner.nextLine();
                    ItemMenu item = new Entradas(nome, preco, descricao);
                    this.itens.add(item);
                } else if (categoria.equals("Prato Principal")) {
                    descricao = scanner.nextLine();
                    ItemMenu item = new PratoPrincipal(nome, preco, descricao);
                    this.itens.add(item);
                } else if (categoria.equals("Bebida")) {
                    boolean alcoolica = Boolean.parseBoolean(scanner.nextLine());
                    descricao = scanner.nextLine();
                    ItemMenu item = new Bebida(nome, preco, alcoolica, descricao);
                    this.itens.add(item);
                }

                this.total += preco;
            }
            scanner.close();
        } catch (FileNotFoundException var9) {
            System.out.println("Arquivo não encontrado: " + var9.getMessage());
        } catch (NumberFormatException var10) {
        }
    }
}