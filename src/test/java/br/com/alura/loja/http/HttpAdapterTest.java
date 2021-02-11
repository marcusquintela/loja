package br.com.alura.loja.http;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.buider.OrcamentoBuider;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HttpAdapterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void DeveRegistrarOrcamentoQuandoFinalizar() {

        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();
        orcamento.finalizar();

        Assert.assertEquals(Finalizado.class, orcamento.getSituacao().getClass());

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());

        //Método lança exceção devido a não implementadação da JavaHttpClient
        registroDeOrcamento.registrar(orcamento);
    }

    @Test
    public void DeveLevantarExcecaoAoRegistrarOrcamentoQuandoSemFinalizar() {

        thrown.expect(DomainException.class);
        thrown.expectMessage("Orcamento não finalizado!");

        Orcamento orcamento = OrcamentoBuider.build();
        orcamento.aprovar();

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());

        //Método lança exceção devido a não implementadação da JavaHttpClient
        registroDeOrcamento.registrar(orcamento);
    }

}