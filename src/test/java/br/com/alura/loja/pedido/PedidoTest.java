package br.com.alura.loja.pedido;

import br.com.alura.loja.pedido.acoes.AcaoEnviarEmailPedido;
import br.com.alura.loja.pedido.acoes.AcaoGerarLoggerPedido;
import br.com.alura.loja.pedido.acoes.AcaoSalvarPedidoNoBanco;
import org.junit.Test;

import java.util.Arrays;

import static br.com.alura.loja.ConstantesTeste.*;

public class PedidoTest {


    @Test
    public void deveCriarUmPedidoSalvarNoBancoEEnviarEmailQuandoExecutarHandler() {

        GeraPedido geraPedido = new GeraPedido(CLINETE_ANA, VALOR, QUANTIDADE_ITENS);
        GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(
                Arrays.asList(
                        new AcaoSalvarPedidoNoBanco(), //
                        new AcaoEnviarEmailPedido(), //
                        new AcaoGerarLoggerPedido()
                )
        );
        geraPedidoHandler.executa(geraPedido);

    }

}