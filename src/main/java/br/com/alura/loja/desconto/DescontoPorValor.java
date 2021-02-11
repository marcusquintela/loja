package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoPorValor extends Desconto {
    public DescontoPorValor(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal efetivarDesconto(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    public boolean deveAplicarDesconto(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) >= 0;
    }

}
