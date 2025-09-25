package annie470.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "evento_id")
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    @Column(name = "genere")
    private Genere genere;
    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto(){};

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nMaxPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, nMaxPartecipanti, location);
        this.genere= genere;
        this.inStreaming=inStreaming;
    };

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
