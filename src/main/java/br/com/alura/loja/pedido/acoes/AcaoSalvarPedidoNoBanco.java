package br.com.alura.loja.pedido.acoes;

import br.com.alura.loja.pedido.Pedido;

public class AcaoSalvarPedidoNoBanco implements AcaoAposCriacaoPedido {
    @Override
    public void executa(Pedido pedido) {
        System.out.println("Salvando pedido no banco de dados!");
    }
}
