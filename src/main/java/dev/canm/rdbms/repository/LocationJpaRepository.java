package dev.canm.rdbms.repository;


import dev.canm.rdbms.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Location repository, using Spring JpaRepository.
 */
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    /**
     * finds by 'state' with like query.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateLike(String state);

    /**
     * finds by 'state' with not like query.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateNotLike(String state);

    /**
     * finds by 'state' with not like query and ordered by state ASC.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateNotLikeOrderByStateAsc(String state);

    /**
     * finds by 'state' or country.
     * @param state name of the state
     * @param country name of the country
     * @return List of Location
     */
    List<Location> findByStateOrCountry(String state, String country);

    /**
     * finds by 'state' and country.
     * @param state name of the state
     * @param country name of the country
     * @return List of Location
     */
    List<Location> findByStateAndCountry(String state, String country);

    /**
     * finds by 'state' starts with query.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateStartingWith(String state);

    /**
     * finds by 'state' ends with query.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateEndingWith(String state);

    /**
     * finds by 'state' containing with query.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateContaining(String state);

    /**
     * finds by 'state' starts with case-insensitive query.
     * @param state name of the state
     * @return List of Location
     */
    List<Location> findByStateIgnoreCaseStartingWith(String state);

}
