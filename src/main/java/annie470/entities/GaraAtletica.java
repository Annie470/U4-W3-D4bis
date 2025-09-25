package annie470.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "evento_id")
public class GaraAtletica extends Evento{
    @ManyToMany
    @JoinTable(
            name = "gara_persona",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id") )
    private Set<Persona> atleti = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona vincitore;

    public GaraAtletica(){};
    public  GaraAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nMaxPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, nMaxPartecipanti, location);
        this.atleti= atleti;
        this.vincitore= vincitore;
    };


    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
