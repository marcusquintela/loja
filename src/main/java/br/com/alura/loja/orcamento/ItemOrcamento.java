package br.com.alura.loja.orcamento;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
public class ItemOrcamento implements Orcavel{
    private BigDecimal valor;
    @Setter
    private int quantidadeItens;

    public ItemOrcamento(BigDecimal valor) {
        this.valor = valor;
    }
}