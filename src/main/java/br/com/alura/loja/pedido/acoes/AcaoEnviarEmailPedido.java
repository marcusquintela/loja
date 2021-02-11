package br.com.alura.loja.pedido.acoes;

import br.com.alura.loja.pedido.Pedido;

public class AcaoEnviarEmailPedido implements AcaoAposCriacaoPedido {
    @Override
    public void executa(Pedido pedido) {
        System.out.println("Enviando email com os dados do pedido!");
    }
}
