package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acoes.AcaoAposCriacaoPedido;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class GeraPedidoHandler {

    private List<AcaoAposCriacaoPedido> acoes;

    public void executa(GeraPedido dados){
        Orcamento orcamento = new Orcamento();
        ItemOrcamento itemOrcamento = new ItemOrcamento(dados.getValorOrcamento());
        itemOrcamento.setQuantidadeItens(dados.getQuantidadeItens());
        orcamento.adiconarItem(itemOrcamento);

        Pedido pedido = new Pedido(dados.getNome(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executa(pedido));
    }
}
