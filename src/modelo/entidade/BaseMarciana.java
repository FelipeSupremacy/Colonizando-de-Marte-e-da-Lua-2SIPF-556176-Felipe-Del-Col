package modelo.entidade;

public class BaseMarciana extends EntidadeEspacial {

    private int producaoOxigenio;

    public BaseMarciana(String nome, String localizacao, double eficiencia, int producaoOxigenio) {
        super(nome, localizacao, eficiencia);
        this.producaoOxigenio = producaoOxigenio;
    }

    @Override
    public double calcularIndicador() {
        return getEficiencia() * producaoOxigenio;
    }

    @Override
    public String gerarRelatorio() {

        return super.gerarRelatorio() + "\nProdução Oxigênio: " + producaoOxigenio + "\nCapacidade Marciana: " + calcularIndicador();
    }
}
