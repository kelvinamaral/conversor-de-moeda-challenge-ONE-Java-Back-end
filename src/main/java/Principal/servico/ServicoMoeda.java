package Principal.servico;

import Principal.modelo.Moeda;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ServicoMoeda {
    // 1. Lê a chave da API da variável de ambiente
    private static final String API_KEY = System.getenv("EXCHANGE_RATE_API_KEY");
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public Map<String, Moeda> obterTaxasDeCambio() throws Exception {
        // 2. Adiciona uma verificação para garantir que a chave foi carregada
        if (API_KEY == null || API_KEY.trim().isEmpty()) {
            throw new IllegalStateException("A variável de ambiente 'EXCHANGE_RATE_API_KEY' não está definida.");
        }

        URL url = new URL(API_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonObject jsonObject = jp.parse(new InputStreamReader(request.getInputStream())).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        Map<String, Moeda> taxasDeCambio = new HashMap<>();
        for (String key : rates.keySet()) {
            taxasDeCambio.put(key, new Moeda(key, rates.get(key).getAsDouble()));
        }

        return taxasDeCambio;
    }
}