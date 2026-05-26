package modelo.entidade;

public class BaseLunar extends EntidadeEspacial {

    private int astronautas;

    public BaseLunar(String nome, String localizacao, double eficiencia, int astronautas) {
        super(nome, localizacao, eficiencia);
        this.astronautas = astronautas;
    }

    @Override
    public double calcularIndicador() {
        return getEficiencia() * astronautas;
    }

    @Override
    public String gerarRelatorio() {
        return super.gerarRelatorio() + "\nAstronautas: " + astronautas + "\nProdução Lunar: " + calcularIndicador();
    }
}
