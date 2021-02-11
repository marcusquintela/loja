package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class Desconto {

    protected Desconto proximo;

    protected abstract BigDecimal efetivarDesconto(Orcamento orcamento);
    public abstract boolean deveAplicarDesconto(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento){
        if(deveAplicarDesconto(orcamento)){
            return efetivarDesconto(orcamento);
        }
        return proximo.calcular(orcamento);
    }

}
