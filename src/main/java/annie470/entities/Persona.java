package annie470.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Sex sex;
    @OneToMany (mappedBy = "persona")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    public Persona(){};

    public Persona(String nome, String cognome, String email, LocalDate dataNascita, Sex sex){
        this.nome=nome;
        this.cognome=cognome;
        this.email= (email != null && !email.isEmpty()) ? email : null;
        this.dataNascita=dataNascita;
        this.sex=sex;
    };

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", sex=" + sex + '\'' + partecipazioni +
                '}';
    }
}
