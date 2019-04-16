package dev.canm.rdbms.audit.model;

import java.io.Serializable;

/**
 * Base class for entities.
 * @param <T>
 */
public interface Model<T> extends Serializable {

    /**
     * Gets ID.
     *
     * @return ID of the entity
     */
    T getId();

    /**
     * Sets ID.
     * @param t ID of the entity
     */
    void setId(T t);

}
