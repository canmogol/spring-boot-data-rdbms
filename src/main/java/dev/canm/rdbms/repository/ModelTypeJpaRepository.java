package dev.canm.rdbms.repository;

import dev.canm.rdbms.model.ModelType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ModelType Repository.
 */
public interface ModelTypeJpaRepository extends JpaRepository<ModelType, Long> {
}
