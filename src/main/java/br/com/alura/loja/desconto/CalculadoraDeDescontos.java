package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {
    public BigDecimal calcular(Orcamento orcamento) {
        Desconto cadeiaDeDescontos =
                new DescontoPorItens(
                        new DescontoPorValor(
                                new SemDesconto(null)));

        return cadeiaDeDescontos.calcular(orcamento);
    }
}
