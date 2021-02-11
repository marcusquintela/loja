package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoPorItens extends Desconto {

    public DescontoPorItens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetivarDesconto(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    public boolean deveAplicarDesconto(Orcamento orcamento) {
        return orcamento.getQuantidadeItens() >= 5;
    }

}
