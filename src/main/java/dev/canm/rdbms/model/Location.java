package dev.canm.rdbms.model;

import com.sun.tools.internal.xjc.model.Model;
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
 * Location Entity.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Audited
@Table(name = "T_LOCATION")
public class Location extends AuditModel<Long> {

    private static final long serialVersionUID = -1190727653697284470L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "L_ID")
    private Long id;

    @Column(name = "L_STATE")
    private String state;

    @Column(name = "L_COUNTRY")
    private String country;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "L_ID")
    private List<Manufacturer> manufacturers = new ArrayList<>();

}
