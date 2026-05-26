package modelo.entidade;

public class EstacaoEnergia extends EntidadeEspacial {

    private double energiaGerada;

    public EstacaoEnergia(String nome, String localizacao, double eficiencia, double energiaGerada) {
        super(nome, localizacao, eficiencia);
        this.energiaGerada = energiaGerada;
    }

    @Override
    public double calcularIndicador() {
        return getEficiencia() * energiaGerada;
    }

    @Override
    public String gerarRelatorio() {
        return super.gerarRelatorio() + "\nEnergia gerada: " + energiaGerada + "\nCapacidade energética: " + calcularIndicador();
    }
}
