package br.com.alura.loja.buider;

import br.com.alura.loja.orcamento.ItemOrcamento;

import static br.com.alura.loja.ConstantesTeste.*;

public class ItemOrcamentoBuider {

    public static ItemOrcamento build() {
        ItemOrcamento itemOrcamento = new ItemOrcamento(VALOR);
        itemOrcamento.setQuantidadeItens(QUANTIDADE_ITENS);
        return itemOrcamento;
    }

    public static ItemOrcamento buildDescontoItem() {
        ItemOrcamento itemOrcamento = new ItemOrcamento(VALOR);
        itemOrcamento.setQuantidadeItens(QUANTIDADE_ITENS_DESCONTO);
        return itemOrcamento;
    }

    public static ItemOrcamento buildDescontoValor() {
        ItemOrcamento itemOrcamento = new ItemOrcamento(VALOR_DESCONTO);
        itemOrcamento.setQuantidadeItens(QUANTIDADE_ITENS);
        return itemOrcamento;
    }
}
