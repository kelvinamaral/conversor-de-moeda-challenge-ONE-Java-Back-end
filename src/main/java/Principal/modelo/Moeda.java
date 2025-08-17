package Principal.modelo;

public class Moeda {
    private String codigo;
    private double taxa;

    public Moeda(String codigo, double taxa) {
        this.codigo = codigo;
        this.taxa = taxa;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getTaxa() {
        return taxa;
    }
}