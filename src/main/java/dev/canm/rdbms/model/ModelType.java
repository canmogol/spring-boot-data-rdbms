package dev.canm.rdbms.model;

import dev.canm.rdbms.audit.model.AuditModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Model Type Entity.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Audited
@Table(name = "T_MODEL_TYPE")
public class ModelType extends AuditModel<Long> {

    private static final long serialVersionUID = -4374907277175989296L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MT_ID")
    private Long id;

    @Column(name = "MT_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "MT_ID")
    private List<GuitarModel> guitarModels = new ArrayList<>();

}
