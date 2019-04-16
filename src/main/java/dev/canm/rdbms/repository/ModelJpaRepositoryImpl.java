package dev.canm.rdbms.repository;

import lombok.extern.slf4j.Slf4j;

/**
 * GuitarModel custom repository default implementation.
 */
@Slf4j
public class ModelJpaRepositoryImpl implements ModelJpaRepositoryCustom {

    /**
     * A custom method.
     */
    @Override
    public final void aCustomMethod() {
        log.info("ModelJpaRepositoryImpl.aCustomMethod");
    }

}
