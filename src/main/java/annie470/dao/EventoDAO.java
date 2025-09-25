package annie470.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import annie470.entities.Evento;
import annie470.exceptions.ElementoNonTrovatoException;

import java.util.UUID;

public class EventoDAO {

    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento e) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(e);
        transaction.commit();
    }

    public Evento getById(String id) {
        UUID uuid = UUID.fromString(id);
        Evento evTrovato = entityManager.find(Evento.class, uuid);
        if (evTrovato == null) {
            throw new ElementoNonTrovatoException("EVENTO NON PRESENTE IN DB O ID NON CORRETTO");
        }
        return  evTrovato;
    };
    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        Evento evT = this.getById(String.valueOf(uuid));
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(evT);
        transaction.commit();
        System.out.println("Evento rimosso: " + evT);
    }
}

