package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class SemDesconto extends Desconto {

    public SemDesconto(Desconto proximo) {
        super(null);
    }

    public BigDecimal efetivarDesconto(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    public boolean deveAplicarDesconto(Orcamento orcamento) {
        return true;
    }

}
