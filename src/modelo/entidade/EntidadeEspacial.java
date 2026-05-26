package modelo.entidade;

import modelo.interfaces.Calculavel;
import modelo.interfaces.Relatorio;

public abstract class EntidadeEspacial
        implements Calculavel, Relatorio {

    private String nome;
    private String localizacao;
    private double eficiencia;

    public EntidadeEspacial(String nome,
                            String localizacao,
                            double eficiencia) {

        this.nome = nome;
        this.localizacao = localizacao;
        this.eficiencia = eficiencia;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public String gerarRelatorio() {

        return "Nome: " + nome + "\nLocalização: " + localizacao + "\nEficiência: " + eficiencia;
    }
}
