package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class Imposto {

    private Imposto outro;

    public abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento){
        BigDecimal valorImposto = realizarCalculo(orcamento);
        BigDecimal valorDoOutroImposto = outro !=null ? outro.calcular(orcamento) : BigDecimal.ZERO;

        return valorImposto.add(valorDoOutroImposto);
    }
}
