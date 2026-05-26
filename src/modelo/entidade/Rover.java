package modelo.entidade;

public class Rover extends EntidadeEspacial {

    private double distanciaExplorada;

    public Rover(String nome, String localizacao, double eficiencia, double distanciaExplorada) {
        super(nome, localizacao, eficiencia);
        this.distanciaExplorada = distanciaExplorada;
    }

    @Override
    public double calcularIndicador() {
        return getEficiencia() * distanciaExplorada;
    }

    @Override
    public String gerarRelatorio() {
        return super.gerarRelatorio() + "\nDistância explorada: " + distanciaExplorada + "\nExploração: " + calcularIndicador();
    }
}
