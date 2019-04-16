package dev.canm.rdbms.audit.model;

import dev.canm.rdbms.audit.listener.AuditModelListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

/**
 * Mapped super class for other entities which are audited.
 *
 * @param <T>
 */
@Data
@MappedSuperclass
@EntityListeners({AuditModelListener.class})
@EqualsAndHashCode(callSuper = false)
public abstract class AuditModel<T> extends BaseModel<T> {

    private static final long serialVersionUID = 1419022173740235697L;

    @Column(name = "AUM_CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUM_CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "AUM_UPDATED_BY")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUM_UPDATE_DATE")
    private LocalDateTime updateDate;

    @Column(name = "AUM_DELETED_BY")
    private String deletedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUM_DELETED_DATE")
    private LocalDateTime deleteDate;

}
