package br.com.alura.loja.imposto;

import br.com.alura.loja.buider.OrcamentoBuider;
import br.com.alura.loja.orcamento.Orcamento;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

public class CalculadoraDeImpostosTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    CalculadoraDeImpostos calculadoraDeImpostos;


    @Test
    public void deveTestarImpostoQuandoReceberOrcamentoEImpostoICMS() {
        BigDecimal resultadoEsperado = new BigDecimal("10.0");
        Orcamento orcamento = OrcamentoBuider.build();
        BigDecimal resultadoObtido = calculadoraDeImpostos.calcular(orcamento, new ICMS(null));
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void deveTestarImpostoQuandoReceberOrcamentoEImpostoISS() {
        BigDecimal resultadoEsperado = new BigDecimal("6.00");
        Orcamento orcamento = OrcamentoBuider.build();
        BigDecimal resultadoObtido = calculadoraDeImpostos.calcular(orcamento, new ISS(null));
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void deveTestarImpostoQuandoReceberOrcamentoEImpostosISSeICMS() {
        BigDecimal resultadoEsperado = new BigDecimal("16.00");
        Orcamento orcamento = OrcamentoBuider.build();
        BigDecimal resultadoObtido = calculadoraDeImpostos.calcular(orcamento, new ISS(new ICMS(null)));
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }

}