package Principal.servico;

import Principal.modelo.Moeda;

import java.util.Map;

public class ConversorMoeda {
    private Map<String, Moeda> taxasDeCambio;

    public ConversorMoeda(Map<String, Moeda> taxasDeCambio) {
        this.taxasDeCambio = taxasDeCambio;
    }

    public double converter(String deMoeda, String paraMoeda, double valor) {
        double taxaDe = taxasDeCambio.get(deMoeda).getTaxa();
        double taxaPara = taxasDeCambio.get(paraMoeda).getTaxa();
        return (valor / taxaDe) * taxaPara;
    }
}