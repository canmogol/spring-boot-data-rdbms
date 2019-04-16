package dev.canm.rdbms.repository;

import dev.canm.rdbms.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Manufacturer repository with with native query example.
 */
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

    /**
     * Finds Manufacturers found before given date.
     *
     * @param date found date.
     * @return List of Manufacturers
     */
    List<Manufacturer> findByFoundedDateBefore(Date date);

    /**
     * Finds the first Manufacturers found before given date.
     *
     * @param date found date
     * @return List of Manufacturers
     */
    Manufacturer findFirstByFoundedDateBefore(Date date);

    /**
     * Finds top 5 Manufacturers found before given date.
     *
     * @param date found date
     * @return List of Manufacturers
     */
    List<Manufacturer> findTop5ByFoundedDateBefore(Date date);

    /**
     * Finds distinct Manufacturers by the name.
     *
     * @param name name
     * @return Manufacturers
     */
    Manufacturer findDistinctManifacturerByNameLike(String name);

    /**
     * Finds all the acoustic guitar manufacturers by name.
     *
     * @param name Name
     * @return List of Manufacturers
     */
    // "Manufacturer.getAllThatSellAcoustics" is a native query
    // "Manufacturer." first part is the generic type of this repository
    // second part ".getAllThatSellAcoustics" is the native query name
    // match the name of this method to the native method and it should work.
    List<Manufacturer> getAllThatSellAcoustics(String name);

}
