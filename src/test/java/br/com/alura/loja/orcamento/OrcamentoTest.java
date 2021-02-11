package br.com.alura.loja.orcamento;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.buider.OrcamentoBuider;
import br.com.alura.loja.orcamento.situacao.Aprovado;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.Reprovado;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static br.com.alura.loja.ConstantesTeste.VALOR;

public class OrcamentoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deveAplicarDescontoExtraDeCincoPorcentoQuandoEstiverNoEstadoEmAnalise() {
        BigDecimal resultadoEsperado = new BigDecimal("95.00");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aplicarDescontoExtra();
        Assert.assertEquals(resultadoEsperado, orcamento.getValor());
    }

    @Test
    public void deveAplicarDescontoExtraDeDoisPorcentoQuandoEstiverNoEstadoAprovado() {
        BigDecimal resultadoEsperado = new BigDecimal("98.00");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        orcamento.aplicarDescontoExtra();
        Assert.assertEquals(resultadoEsperado, orcamento.getValor());
    }

    @Test
    public void naoDeveAplicarDescontoExtraQuandoEstiverNoEstadoReprovado() {
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.reprovar();
        orcamento.aplicarDescontoExtra();
        Assert.assertEquals(VALOR, orcamento.getValor());
    }

    @Test
    public void deveAprovarOrcamentoQuantoEstiverNoEstadoEmAnalise() {
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        Assert.assertEquals(Aprovado.class, orcamento.getSituacao().getClass());
    }

    @Test
    public void deveReprovarOrcamentoQuantoEstiverNoEstadoEmAnalise() {
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.reprovar();
        Assert.assertEquals(Reprovado.class, orcamento.getSituacao().getClass());
    }

    @Test
    public void deveReprovarOrcamentoQuantoEstiverNoEstadoAprovado() {
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        orcamento.finalizar();
        Assert.assertEquals(Finalizado.class, orcamento.getSituacao().getClass());
    }

    @Test
    public void deveReprovarOrcamentoQuantoEstiverNoEstadoReprovado() {
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.reprovar();
        orcamento.finalizar();
        Assert.assertEquals(Finalizado.class, orcamento.getSituacao().getClass());
    }

    @Test
    public void deveLancarExcecaoQuantoTentarFinalizarOracamentoEEstiverNoEstadoEmAnalise() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Orçamento não pode ser finalizado!");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.finalizar();
    }

    @Test
    public void deveLancarExcecaoQuantoTentarAprovarOracamentoEEstiverNoEstadoReprovado() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Orçamento não pode ser aprovado!");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.reprovar();
        orcamento.aprovar();
    }

    @Test
    public void deveLancarExcecaoQuantoTentarAprovarOracamentoEEstiverNoEstadoAprovado() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Orçamento não pode ser aprovado!");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        orcamento.aprovar();
    }

    @Test
    public void deveLancarExcecaoQuantoTentarAprovarOracamentoEEstiverNoEstadoFinalizado() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Orçamento não pode ser aprovado!");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        orcamento.finalizar();
        orcamento.aprovar();
    }

    @Test
    public void deveLancarExcecaoQuantoTentarReprovarOracamentoEEstiverNoEstadoFinalizado() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Orçamento não pode ser reprovado!");
        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        orcamento.finalizar();
        orcamento.reprovar();
    }

    @Test
    public void deveAceitarUmOrcamentoQuandoAdicionarItem() {
        BigDecimal resultadoEsperado = new BigDecimal("600");

        Orcamento orcamentoAntigo = OrcamentoBuider.build();
        orcamentoAntigo.reprovar();

        Orcamento orcamentoNovo = OrcamentoBuider.buildDescontoValor();
        orcamentoNovo.adiconarItem(orcamentoAntigo);

        Assert.assertEquals(resultadoEsperado, orcamentoNovo.getValor());

    }
}