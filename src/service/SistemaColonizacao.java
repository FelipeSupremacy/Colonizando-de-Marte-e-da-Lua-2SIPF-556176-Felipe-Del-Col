package service;

import modelo.entidade.*;
import modelo.evento.EventoSistema;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaColonizacao {

    private ArrayList<EntidadeEspacial> entidades;
    private ArrayList<EventoSistema> eventos;

    private IPOService ipoService;

    public SistemaColonizacao() {

        entidades = new ArrayList<>();
        eventos = new ArrayList<>();

        ipoService = new IPOService();
    }

    public void iniciar() {

        while (true) {

            String menu = """
                    === SPACE COLONY MANAGER ===
                    
                    1 - Cadastrar entidade
                    2 - Listar entidades
                    3 - Calcular IPO
                    4 - Registrar evento
                    5 - Consultar eventos
                    6 - Relatório geral
                    0 - Sair
                    """;

            int opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(menu));

            switch (opcao) {

                case 1 -> cadastrarEntidade();

                case 2 -> listarEntidades();

                case 3 -> calcularIPO();

                case 4 -> registrarEvento();

                case 5 -> consultarEventos();

                case 6 -> relatorioGeral();

                case 0 -> System.exit(0);
            }
        }
    }

    private void cadastrarEntidade() {

        String[] tipos = {
                "Base Lunar",
                "Base Marciana",
                "Rover",
                "Estação Energia"
        };

        String tipo = (String)
                JOptionPane.showInputDialog(
                        null,
                        "Escolha o tipo",
                        "Cadastro",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tipos,
                        tipos[0]);

        String nome = JOptionPane.showInputDialog("Nome:");
        String local = JOptionPane.showInputDialog("Localização:");
        double eficiencia = Double.parseDouble(
                JOptionPane.showInputDialog("Eficiência:"));

        switch (tipo) {

            case "Base Lunar" -> {

                int astronautas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade astronautas:"));
                entidades.add(new BaseLunar(nome, local, eficiencia, astronautas));
            }

            case "Base Marciana" -> {

                int oxigenio = Integer.parseInt(JOptionPane.showInputDialog("Produção de oxigênio:"));
                entidades.add(new BaseMarciana(nome, local, eficiencia, oxigenio));
            }

            case "Rover" -> {

                double distancia = Double.parseDouble(JOptionPane.showInputDialog("Distância explorada:"));
                entidades.add(new Rover(nome, local, eficiencia, distancia));
            }

            case "Estação Energia" -> {

                double energia = Double.parseDouble(JOptionPane.showInputDialog("Energia gerada:"));

                entidades.add(new EstacaoEnergia(nome, local, eficiencia, energia));
            }
        }

        JOptionPane.showMessageDialog(null, "Entidade cadastrada!");
    }

    private void listarEntidades() {

        StringBuilder sb = new StringBuilder();

        for (EntidadeEspacial e : entidades) {

            sb.append(e.gerarRelatorio()).append("\n----------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void calcularIPO() {

        double ipo = ipoService.calcularIPO(entidades);

        String classificacao = ipoService.classificarIPO(ipo);

        JOptionPane.showMessageDialog(null, "IPO: " + ipo + "\nClassificação: " + classificacao);
    }

    private void registrarEvento() {

        String descricao = JOptionPane.showInputDialog("Descrição evento:");

        eventos.add(new EventoSistema(descricao, LocalDate.now().toString()));

        JOptionPane.showMessageDialog(null, "Evento registrado!");
    }

    private void consultarEventos() {

        StringBuilder sb = new StringBuilder();

        for (EventoSistema e : eventos) {

            sb.append(e).append("\n-------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void relatorioGeral() {

        StringBuilder sb = new StringBuilder();

        sb.append("=== RELATÓRIO GERAL ===\n\n");

        for (EntidadeEspacial e : entidades) {

            sb.append(e.gerarRelatorio()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
