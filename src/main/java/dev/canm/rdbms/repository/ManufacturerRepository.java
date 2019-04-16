package dev.canm.rdbms.repository;

import dev.canm.rdbms.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Manufacturer Repository backed by the {@link EntityManager} and {@link ManufacturerJpaRepository}.
 */
@Repository
public class ManufacturerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ManufacturerJpaRepository manufacturerJpaRepository;

    /**
     * Creates a Manufacturer.
     *
     * @param man Manufacturer
     * @return created Manufacturer
     */
    public final Manufacturer create(final Manufacturer man) {
        return manufacturerJpaRepository.saveAndFlush(man);
    }

    /**
     * Updates the given Manufacturer.
     *
     * @param man Manufacturer
     * @return updated Manufacturer
     */
    public final Manufacturer update(final Manufacturer man) {
        return manufacturerJpaRepository.saveAndFlush(man);
    }

    /**
     * Deletes the given Manufacturer.
     *
     * @param man Manufacturer
     */
    public final void delete(final Manufacturer man) {
        manufacturerJpaRepository.delete(man);
        manufacturerJpaRepository.flush();
    }

    /**
     * Finds the Manufacturer by ID.
     *
     * @param id Manufacturer's ID
     * @return Manufacturer
     */
    public final Manufacturer find(final Long id) {
        return manufacturerJpaRepository.findById(id)
            .orElse(null);
    }

    /**
     * Custom finder.
     *
     * @param date founded before date.
     * @return List of Manufacturers
     */
    public final List<Manufacturer> getManufacturersFoundedBeforeDate(final Date date) {
        return manufacturerJpaRepository.findByFoundedDateBefore(date);
    }

    /**
     * Custom finder.
     *
     * @param name Manufacturer name
     * @return Manufacturer
     */
    public final Manufacturer getManufacturerByName(final String name) {
        return (Manufacturer) entityManager
            .createQuery("select m from Manufacturer m where m.name like :name")
            .setParameter("name", name + "%").getSingleResult();
    }

    /**
     * Native Query finder.
     *
     * @param modelType model type
     * @return List of Manufacturers
     */
    public final List<Manufacturer> getManufacturersThatSellModelsOfType(final String modelType) {
        @SuppressWarnings("unchecked")
        List<Manufacturer> mans = entityManager
            .createNamedQuery("Manufacturer.getAllThatSellAcoustics", Manufacturer.class)
            .setParameter(1, modelType).getResultList();
        return mans;
    }
}
