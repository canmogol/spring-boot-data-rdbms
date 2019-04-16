package dev.canm.rdbms.audit.model;

import dev.canm.rdbms.audit.listener.BaseModelListener;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * BaseModel definition, mapped super class for other entities.
 * @param <T>
 */
@Data
@MappedSuperclass
@EntityListeners({BaseModelListener.class})
public abstract class BaseModel<T> implements Model<T> {

    private static final long serialVersionUID = -5078006836869173887L;

    @Version
    @Column(name = "BM_VERSION", nullable = false)
    private Long version = 0L;

    @Column(name = "BM_IS_DELETED")
    private boolean deleted = false;

}
