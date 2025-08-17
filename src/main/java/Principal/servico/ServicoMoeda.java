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
    private static final String API_KEY = "f315a34d124a4823a36d94e3";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public Map<String, Moeda> obterTaxasDeCambio() throws Exception {
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