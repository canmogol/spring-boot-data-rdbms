package dev.canm.rdbms.repository;

import dev.canm.rdbms.model.ModelType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * GuitarModel Repository.
 */
@Repository
public class ModelTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Creates ModelType.
     * @param mt ModelType
     * @return persisted ModelType
     */
    public final ModelType create(final ModelType mt) {
        entityManager.persist(mt);
        entityManager.flush();
        return mt;
    }

    /**
     * Updates ModelType.
     * @param mt ModelType
     * @return updated model type.
     */
    public final ModelType update(final ModelType mt) {
        ModelType merged = entityManager.merge(mt);
        entityManager.flush();
        return merged;
    }

    /**
     * Deletes given model type.
     * @param mt ModelType
     */
    public final void delete(final ModelType mt) {
        entityManager.remove(mt);
        entityManager.flush();
    }

    /**
     * Finds the model type by ID.
     * @param id ModelType's ID
     * @return found ModelType or null
     */
    public final ModelType find(final Long id) {
        return entityManager.find(ModelType.class, id);
    }
}
