package annie470.entities;

import jakarta.persistence.*;
import annie470.exceptions.InputException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Entity
@Table(name ="eventi")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column(name = "titolo", nullable = false)
    protected String titolo;
    @Column(name = "data evento", nullable = false)
    protected LocalDate dataEvento;
    @Column(name = "descrizione", nullable = true)
    protected String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo evento", nullable = false)
    protected TipoEvento tipoEvento;
    @Column(name = "n max partecipanti", nullable = false)
    protected int nMaxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id")
    protected Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    public  Evento(){};

    public Evento(String titolo, LocalDate dataEvento, String descrizione,
                  TipoEvento tipoEvento, int nMaxPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.nMaxPartecipanti = nMaxPartecipanti;
        this.location = location;
    };


    public UUID getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public LocalDate getDataEvento() {
        return dataEvento;
    }
    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }
    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public int getnMaxPartecipanti() {
        return nMaxPartecipanti;
    }
    public void setnMaxPartecipanti(int nMaxPartecipanti) {
        this.nMaxPartecipanti = nMaxPartecipanti;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }
    public Location getLocation() {
        return location;
    }
    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", nMaxPartecipanti=" + nMaxPartecipanti +
                ", location=" + location +
                '}';
    }
}
