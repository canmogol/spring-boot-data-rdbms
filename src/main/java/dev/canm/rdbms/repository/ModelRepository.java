package dev.canm.rdbms.repository;

import dev.canm.rdbms.model.GuitarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * Guitar Model Repository.
 */
@Repository
public class ModelRepository {

    public static final int PAGE = 0;
    public static final int SIZE = 10;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelJpaRepository modelJpaRepository;

    /**
     * Create a GuitarModel.
     *
     * @param mod Guitar model
     * @return saved GuitarModel
     */
    public final GuitarModel create(final GuitarModel mod) {
        return modelJpaRepository.saveAndFlush(mod);
    }

    /**
     * Update the given GuitarModel.
     *
     * @param mod Guitar model
     * @return updated GuitarModel.
     */
    public final GuitarModel update(final GuitarModel mod) {
        return modelJpaRepository.saveAndFlush(mod);
    }

    /**
     * Delete the given GuitarModel.
     *
     * @param mod Guitar model to delete.
     */
    public final void delete(final GuitarModel mod) {
        modelJpaRepository.delete(mod);
        modelJpaRepository.flush();
    }

    /**
     * Find the GuitarModel by the ID.
     *
     * @param id model ID.
     * @return found GuitarModel, can be null if the model with ID does not exist.
     */
    public final GuitarModel find(final Long id) {
        return modelJpaRepository.findById(id)
            .orElse(null);
    }

    /**
     * Custom finder, finds the GuitarModels in the given price range.
     *
     * @param lowest  lowest price
     * @param highest highest price
     * @return List of GuitarModels within the given price range.
     */
    public final List<GuitarModel> getModelsInPriceRange(
        final BigDecimal lowest, final BigDecimal highest) {
        return modelJpaRepository.findByPriceLessThanEqualAndPriceGreaterThanEqual(
            lowest, highest
        );
    }

    /**
     * Custom finder, finds the model in the price range and type.
     *
     * @param lowest  price
     * @param highest price
     * @param wood    type
     * @return Page of GuitarModels
     */
    public final Page<GuitarModel> getModelsByPriceRangeAndWoodType(
        final BigDecimal lowest, final BigDecimal highest, final String wood) {
        Sort sort = new Sort(Sort.Direction.ASC, "name");
        Pageable page = PageRequest.of(PAGE, SIZE, sort);
        return modelJpaRepository.queryByPriceRangeAndWoodType(
            lowest, highest, "%" + wood + "%", page);
    }

    /**
     * NamedQuery finder, finds the models by the given type.
     *
     * @param modelType model type
     * @return List of GuitarModels belongs to this type.
     */
    public final List<GuitarModel> getModelsByType(final String modelType) {
        @SuppressWarnings("unchecked")
        List<GuitarModel> mods = entityManager
            .createNamedQuery("GuitarModel.findAllGuitarModelsByType")
            .setParameter("name", modelType)
            .getResultList();
        return mods;
    }

    /**
     * Finds the number of models in the repository.
     *
     * @return number of GuitarModels
     */
    public final Long getModelCount() {
        return modelJpaRepository.count();
    }

}
