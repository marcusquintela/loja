package br.com.alura.loja.orcamento;

import br.com.alura.loja.buider.OrcamentoBuider;
import org.junit.Test;

public class OrcamentoProxyTest {

    @Test
    public void deveUtilizaroProxyQuandoChamarGetValor(){
        Orcamento orcamento = OrcamentoBuider.build();

        OrcamentoProxy orcamentoProxy = new OrcamentoProxy(orcamento);

        orcamentoProxy.getValor();
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());

    }

}