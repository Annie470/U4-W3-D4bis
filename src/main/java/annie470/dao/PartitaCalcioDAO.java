package annie470.dao;

import annie470.entities.Partecipazione;
import annie470.entities.PartitaCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartitaCalcioDAO {
    private final EntityManager entityManager;

    public PartitaCalcioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(PartitaCalcio p) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(p);
        transaction.commit();
    }
}
