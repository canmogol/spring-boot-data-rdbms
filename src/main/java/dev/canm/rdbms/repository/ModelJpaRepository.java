package dev.canm.rdbms.repository;

import dev.canm.rdbms.model.GuitarModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.math.BigDecimal;
import java.util.List;

/**
 * GuitarModel repository using Spring JPA Repository.
 */
public interface ModelJpaRepository extends JpaRepository<GuitarModel, Long>, ModelJpaRepositoryCustom {

    /**
     * Find GuitarModels in the given price range.
     *
     * @param less    highest price
     * @param greater lowest price
     * @return List of GuitarModels
     */
    List<GuitarModel> findByPriceLessThanEqualAndPriceGreaterThanEqual(
        BigDecimal less, BigDecimal greater
    );

    /**
     * Finds the GuitarModels with the given type names.
     *
     * @param types List of types
     * @return List of models
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<GuitarModel> findByModelTypeNameIn(List<String> types);

    /**
     * finds GuitarModels between the range and with the type.
     *
     * @param decimal1 lowest price
     * @param decimal2 highest price
     * @param s        wood type
     * @return List of models
     */
    @Query(
        value = "select m from GuitarModel m where m.price >= :lowest "
            + "and m.price <= :highest and m.woodType like :wood",
        nativeQuery = false
    )
    List<GuitarModel> queryByPriceRangeAndWoodType(
        @Param("lowest") BigDecimal decimal1,
        @Param("highest") BigDecimal decimal2,
        @Param("wood") String s);

    /**
     * finds GuitarModels between the range and with the type per page.
     *
     * @param decimal1 lowest price
     * @param decimal2 highest price
     * @param s        wood type
     * @param page     pagination entry
     * @return List of models
     */
    @Query(value = "select m from GuitarModel m where m.price >= :lowest "
        + "and m.price <= :highest and m.woodType like :wood")
    Page<GuitarModel> queryByPriceRangeAndWoodType(
        @Param("lowest") BigDecimal decimal1,
        @Param("highest") BigDecimal decimal2,
        @Param("wood") String s,
        Pageable page);


    /**
     * Updates the GuitarModel's name with the ID.
     *
     * @param name new name
     * @param id   ID of the GuitarModel
     * @return number of entities updated by the query.
     */
    @Modifying
    @Query(value = "update GuitarModel m set m.name = ?1 where m.id = ?2")
    int updateByName(String name, Long id);

    /**
     * Finds all the GuitarModels with the given name.
     *
     * @param type name of the GuitarModel
     * @return List of models
     */
    // otherwise you can set the named query to the Query annotation as follows.
    @Query(name = "GuitarModel.findAllGuitarModelsByType")
    List<GuitarModel> findTypesUsingNamedQuery(@Param("name") String type);

}
