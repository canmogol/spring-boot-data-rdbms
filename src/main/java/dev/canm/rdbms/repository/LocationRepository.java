
package dev.canm.rdbms.repository;


import dev.canm.rdbms.model.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Location repository using an {@link EntityManager}.
 */
@Repository
public class LocationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Create a location.
     *
     * @param loc location to be created.
     * @return managed and persistent instance.
     */
    public final Location create(final Location loc) {
        entityManager.persist(loc);
        entityManager.flush();
        return loc;
    }

    /**
     * Update a location.
     *
     * @param loc location to be updated.
     * @return the managed instance that the state was merged to.
     */
    public final Location update(final Location loc) {
        Location managedInstance = entityManager.merge(loc);
        entityManager.flush();
        return managedInstance;
    }

    /**
     * Delete a location.
     *
     * @param loc location to be deleted.
     */
    public final void delete(final Location loc) {
        entityManager.remove(loc);
        entityManager.flush();
    }

    /**
     * Finds the location with ID.
     *
     * @param id location ID
     * @return the found entity instance or null if the entity does not exist.
     */
    public final Location find(final Long id) {
        return entityManager.find(Location.class, id);
    }

    /**
     * Custom find method, finds the Location by State name.
     *
     * @param name state name or prefix.
     * @return list of Locations.
     */
    public final List<Location> getLocationByStateName(final String name) {
        String stateName = String.format("%s%%", name);
        @SuppressWarnings("unchecked")
        List<Location> locs = entityManager
            .createQuery("select l from Location l where l.state like :state")
            .setParameter("state", stateName).getResultList();
        return locs;
    }
}
