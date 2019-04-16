package dev.canm.rdbms.audit.model;

import dev.canm.rdbms.audit.listener.AuditModelListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Mapped super class for other entities which are audited.
 *
 * @param <T>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
@EntityListeners({AuditModelListener.class})
public abstract class AuditModel<T extends Serializable> extends BaseModel<T> {

    private static final long serialVersionUID = 1419022173740235697L;

    @Column(name = "AUM_DELETED_BY")
    private String deletedBy;

    @Column(name = "AUM_DELETED_DATE")
    private LocalDateTime deleteDate;

    @CreatedBy
    @Column(name = "AUM_CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "AUM_CREATED_DATE")
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "AUM_UPDATED_BY")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "AUM_UPDATED_DATE")
    private LocalDateTime updatedDate;

}
