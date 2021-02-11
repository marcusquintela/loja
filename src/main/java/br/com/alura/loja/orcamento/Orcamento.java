package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Orcamento implements Orcavel{

    private BigDecimal valor;
    private List<Orcavel> listaItens;

    @Setter
    private SituacaoOrcamento situacao;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.listaItens = new ArrayList<>();
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }


    public boolean isFinalizado() {
        return this.situacao instanceof Finalizado;
    }

    public int getQuantidadeItens() {
        return listaItens.stream().mapToInt(Orcavel::getQuantidadeItens).sum();
    }

    public void adiconarItem(Orcavel itemOrcamento) {
        valor = valor.add(itemOrcamento.getValor());
        listaItens.add(itemOrcamento);
    }

    public BigDecimal getValor() {
//        try {
//          //  Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return valor;
    }
}
