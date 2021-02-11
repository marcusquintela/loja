package br.com.alura.loja.desconto;

import br.com.alura.loja.buider.OrcamentoBuider;
import br.com.alura.loja.orcamento.Orcamento;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

public class CalculadoraDeDescontosTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    private CalculadoraDeDescontos calculadoraDeDescontos;

    @Test
    public void deveCalcularDescontoQuandoOrcamentoTiverMaisdeCincoItens() {
        BigDecimal resultadoEsperado = new BigDecimal("10.0");
        Orcamento orcamento = OrcamentoBuider.buildDescontoItem();
        BigDecimal resultadoObtido = calculadoraDeDescontos.calcular(orcamento);
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void deveCalcularDescontoQuandoOrcamentoTiverMaiorQue500() {
        BigDecimal resultadoEsperado = new BigDecimal("50.0");
        Orcamento orcamento = OrcamentoBuider.buildDescontoValor();
        BigDecimal resultadoObtido = calculadoraDeDescontos.calcular(orcamento);
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void naodeveCalcularDescontoQuandoOrcamentoNaoPassarDasRegrasDeDesconto() {
        BigDecimal resultadoEsperado = BigDecimal.ZERO;
        Orcamento orcamento = OrcamentoBuider.build();
        BigDecimal resultadoObtido = calculadoraDeDescontos.calcular(orcamento);
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }
}