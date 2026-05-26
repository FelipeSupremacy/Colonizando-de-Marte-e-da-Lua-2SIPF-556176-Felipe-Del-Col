package service;

import modelo.entidade.EntidadeEspacial;

import java.util.ArrayList;

public class IPOService {

    public double calcularIPO(
            ArrayList<EntidadeEspacial> entidades) {

        double soma = 0;

        for (EntidadeEspacial e : entidades) {
            soma += e.calcularIndicador();
        }

        return soma / entidades.size();
    }

    public String classificarIPO(double ipo) {

        if (ipo >= 800) {
            return "VERDE";
        }

        if (ipo >= 400) {
            return "AMARELO";
        }

        return "VERMELHO";
    }
}
