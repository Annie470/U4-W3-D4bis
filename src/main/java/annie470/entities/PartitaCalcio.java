package annie470.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "evento_id")
public class PartitaCalcio extends Evento{
    @Column(name = "squadra_casa", nullable = false)
    private String squadraCasa;
    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;
    @Column(name = "squadra_vincente", nullable = true)
    private String squadraVincente;
    @Column(name = "gol_casa", nullable = false)
    private int golCasa;
    @Column(name = "gol_ospite", nullable = false)
    private int golOspite;

    public PartitaCalcio(){};

    public PartitaCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nMaxPartecipanti, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int golCasa, int golOspite){
        super(titolo, dataEvento, descrizione, tipoEvento, nMaxPartecipanti, location);
        this.squadraCasa=squadraCasa;
        this.squadraOspite=squadraOspite;
        this.squadraVincente=squadraVincente;
        this.golCasa=golCasa;
        this.golOspite=golOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}';
    }
}
