package br.com.alura.loja.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class GeraPedido {

    private String nome;
    private BigDecimal valorOrcamento;
    private int quantidadeItens;

}
