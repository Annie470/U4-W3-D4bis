package annie470;


import annie470.dao.*;
import annie470.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbeventipu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO evd = new EventoDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO pad = new PartecipazioneDAO(em);
        PartitaCalcioDAO pcd = new PartitaCalcioDAO(em);

        /*Location l1 = new Location("Mare&Monti restaurant", "Napoli");
        Location l2 = new Location("Campetti Circolo UnitedNa", "Salerno");
        ld.save(l1);
        ld.save(l2);

        Persona p1 = new Persona("Noemi", "Milone", "noemil@gmail.com", LocalDate.of(1998,12,13), Sex.FEMMINA);
        Persona p2 = new Persona("Taras", "Buha", null, LocalDate.of(2002,4,21), Sex.MASCHIO);
        pd.save(p1);
        pd.save(p2);*/

        Location lf = em.find(Location.class, UUID.fromString("11d67663-09f1-435d-b006-56af7c64df4f"));
        /*Evento e1 = new Evento("Matrimonio DeNisco", LocalDate.of(2026,6,15), "matrimonio", TipoEvento.PRIVATO, 165, lf);
        evd.save(e1);
        Evento evf = em.find(Evento.class, UUID.fromString("4d084be7-bf95-490c-b2ea-52b829d5c5cb"));
        System.out.println(evf.getLocation().getNome());*/
        Persona pf = em.find(Persona.class, UUID.fromString("3340cdca-2634-4403-83eb-5d8a3b19bfc9"));
        /*Partecipazione p1 = new Partecipazione(Stato.CONFERMATO,pf,evf);
        pad.save(p1);

        PartitaCalcio pc1 = new PartitaCalcio("Verona-Napoli", LocalDate.of(2025,11,10), "partita amichevole", TipoEvento.PUBBLICO,7000,lf, "Napoli", "Verona", null, 1, 1 );
        pcd.save(pc1);
        Persona pf2 = em.find(Persona.class, UUID.fromString("9cce7eeb-cc96-434a-aad1-7385a8cf2521"));
        Set<Persona> atleti = new HashSet<>(); //Set<Persona> atleti = Set.of(pf, pf2);
        atleti.add(pf);
        atleti.add(pf2);

        GaraAtletica g1 = new GaraAtletica("Gara atleti 2025", LocalDate.of(2025,4,10), "Gara staffetta", TipoEvento.PUBBLICO, 3000, lf, atleti, pf2);

        evd.save(g1);

        Concerto c1 = new Concerto("HardcorePunkFest", LocalDate.of(2026,10,10), "Concerto punk all'aperto", TipoEvento.PUBBLICO, 2000, lf, Genere.ROCK, false);
        Concerto c2 = new Concerto("Classica 900", LocalDate.of(2028,7,10), "Concerto musica classica", TipoEvento.PUBBLICO, 800, lf, Genere.CLASSIC, true);
        Concerto c3 = new Concerto("Concerto QOSA", LocalDate.of(2028,1,10), "Concerto QueensOfStoneAge", TipoEvento.PUBBLICO, 40000, lf, Genere.ROCK, true);

        evd.save(c1);
        evd.save(c2);
        evd.save(c3);*/

        evd.getConcertiInStreaming(em);

        System.out.println("TUTTO OK");
    }
}
