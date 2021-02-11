package br.com.alura.loja.buider;

import br.com.alura.loja.orcamento.Orcamento;

public class OrcamentoBuider {

    public static Orcamento build() {
        Orcamento orcamento = new Orcamento();
        orcamento.adiconarItem(ItemOrcamentoBuider.build());
        return orcamento;
    }

    public static Orcamento buildDescontoValor() {
        Orcamento orcamento = new Orcamento();
        orcamento.adiconarItem(ItemOrcamentoBuider.buildDescontoValor());
        return orcamento;
    }

    public static Orcamento buildDescontoItem() {
        Orcamento orcamento = new Orcamento();
        orcamento.adiconarItem(ItemOrcamentoBuider.buildDescontoItem());
        return orcamento;
    }
}
