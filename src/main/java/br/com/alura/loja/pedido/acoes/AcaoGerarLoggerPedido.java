package br.com.alura.loja.pedido.acoes;

import br.com.alura.loja.pedido.Pedido;

public class AcaoGerarLoggerPedido implements AcaoAposCriacaoPedido{
    @Override
    public void executa(Pedido pedido) {
        System.out.println("Pedido gerado = "+pedido);
    }
}
