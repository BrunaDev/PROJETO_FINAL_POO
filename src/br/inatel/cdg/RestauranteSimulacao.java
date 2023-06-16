package br.inatel.cdg;

import java.util.Scanner;

public class RestauranteSimulacao {
    public RestauranteSimulacao() {
    }

    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        Entradas entrada1 = new Entradas("Batata Frita Especial", 30.0, "Batatas fritas cobertas com queijo muçarela derretido e bacon crocante.");
        cardapio.adicionarItem(entrada1);
        Entradas entrada2 = new Entradas("BRUSCHETTA", 30.0, "Dadinhos de tapioca, sendo dois cobertos com cream cheese, camarão.");
        cardapio.adicionarItem(entrada2);
        Entradas entrada3 = new Entradas("Caldo de Camarão", 30.0, "Caldo com camarões, alho, cebola, coentro, pimentões, pimenta de cheiro mandioquinha e leite de coco. Acompanha 4 pãezinhos.");
        cardapio.adicionarItem(entrada3);
        Entradas entrada4 = new Entradas("Caldo de Peixe", 30.0, "Caldo à base de peixe, pimentões, pimenta de cheiro, cebola, alho, leite de coco e coentro. Acompanha cesta de torradas temperadas.");
        cardapio.adicionarItem(entrada4);
        Entradas entrada5 = new Entradas("Camarão à Milanesa", 30.0, "Camarão à milanesa com gergelim. Acompanha molho tártaro.");
        cardapio.adicionarItem(entrada5);
        PratoPrincipal prato1 = new PratoPrincipal("Massa Carbonara", 30.0, "Deliciosa massa italiana com molho carbonara.");
        cardapio.adicionarItem(prato1);
        PratoPrincipal prato2 = new PratoPrincipal("Bife à Parmegiana", 25.0, "Bife empanado coberto com molho de tomate e queijo.");
        cardapio.adicionarItem(prato2);
        PratoPrincipal prato3 = new PratoPrincipal("Espaguete com vegetais (Vegano e sem lactose)", 40.0, "Delicioso espaguete italiano com brócolis, tomate cereja e caponata de berinjela salteados no azeite, alho, cebola e pimenta do reino.");
        cardapio.adicionarItem(prato3);
        PratoPrincipal prato4 = new PratoPrincipal("Camarão Aruba (2 pessoas)", 60.0, "Camarões salteados na cebola e alho, com molho leve de abóbora.");
        cardapio.adicionarItem(prato4);
        PratoPrincipal prato5 = new PratoPrincipal("Filé Alfredo", 50.0, "400g de medalhões de Filé Mignon envolvidos com bacon com molho funghi acompanhado de fettuccine com molho Alfredo preparado com creme de leite fresco.");
        cardapio.adicionarItem(prato5);
        Bebida bebida1 = new Bebida("Refrigerante", 5.0, false, "Refrigerante da sua escolha");
        cardapio.adicionarItem(bebida1);
        Bebida bebida2 = new Bebida("Água de Coco", 7.0, false, "Água de coco fresca direto do Nordeste!");
        cardapio.adicionarItem(bebida2);
        Bebida bebida3 = new Bebida("Soda Italiana", 50.0, false, "Uma incrível Soda Italiana especial da casa");
        cardapio.adicionarItem(bebida3);
        Bebida bebida4 = new Bebida("Vinho Tinto", 50.0, true, "Um delicioso Vinho Tinto Reservado");
        cardapio.adicionarItem(bebida4);
        Bebida bebida5 = new Bebida("Chopp Brahma", 50.0, true, "Delicioso Chopp direto da fábrica");
        cardapio.adicionarItem(bebida5);
        cardapio.exibirCardapio();
        Pedido pedido = new Pedido();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os itens do pedido (digite 'fim' para encerrar):");

        while(true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fim")) {
                pedido.exibirPedido();
                pedido.salvarPedidoEmArquivo("pedido.txt");
                Pedido pedidoCarregado = new Pedido();
                pedidoCarregado.carregarPedidoDeArquivo("pedido.txt");
                pedidoCarregado.exibirPedido();
                return;
            }

            ItemMenu item = cardapio.buscarItem(input);
            if (item == null) {
                System.out.println("Item não encontrado no cardápio.");
            } else {
                pedido.adicionarItem(item);
                System.out.println("Item adicionado ao pedido.");
            }
        }
    }
}