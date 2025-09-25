package annie470.dao;

import annie470.entities.Location;
import annie470.exceptions.ElementoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Location l) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(l);
        transaction.commit();
    }
    public Location getById(UUID id) {
        Location lt = entityManager.find(Location.class, id);
        if (lt == null) {
            throw new ElementoNonTrovatoException("EVENTO NON PRESENTE IN DB O ID NON CORRETTO");
        }
        return  lt;
    };
}
