package annie470.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

   @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

public Partecipazione(Stato stato, Persona persona, Evento evento){
    this.stato=stato;
    this.persona=persona;
    this.evento=evento;
}

    public UUID getId() {
        return id;
    }
    public Stato getStato() {
        return stato;
    }
    public void setStato(Stato stato) {
        this.stato = stato;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", stato=" + stato +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
