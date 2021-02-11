package br.com.alura.loja.orcamento;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class RegistroDeOrcamento {

    private HttpAdapter httpAdapter;

    public void registrar(Orcamento orcamento){
        if(! orcamento.isFinalizado()){
            throw new DomainException("Orcamento não finalizado!");
        };

        String url = "http://api.externa/orcamento";
        Map <String, Object> dados = new HashMap<>();
        dados.put("Valor", orcamento.getValor());
        dados.put("quantidadeDeItens", orcamento.getQuantidadeItens());

        httpAdapter.post(url, dados);
    }
}
