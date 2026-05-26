package modelo.evento;

public class EventoSistema {

    private String descricao;
    private String data;

    public EventoSistema(String descricao, String data) {
        this.descricao = descricao;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Evento: " + descricao + "\nData: " + data;
    }
}
