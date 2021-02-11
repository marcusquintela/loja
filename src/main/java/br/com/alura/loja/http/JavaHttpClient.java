package br.com.alura.loja.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {
    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlAdapter = new URL(url);
            URLConnection urlConnection = urlAdapter.openConnection();
            urlConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Vali sempre cair na Exceção pois a implementação de URL Connection não é o foco desse projeto!");
        }
    }
}
