package dev.canm.rdbms.model;

import dev.canm.rdbms.audit.model.AuditModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GuitarModel Entity.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Audited
@Table(name = "T_GUITAR_MODEL")
@NamedQuery(name = "GuitarModel.findAllGuitarModelsByType",
    query = "select m from GuitarModel m where m.modelType.name = :name")
public class GuitarModel extends AuditModel<Long> {

    private static final long serialVersionUID = 1987970638934488911L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GM_ID")
    private Long id;

    @Column(name = "GM_NAME")
    private String name;

    @Column(name = "GM_PRICE")
    private BigDecimal price;

    @Column(name = "GM_FRETS")
    private int frets;

    @Column(name = "GM_WOOD_TYPE")
    private String woodType;

    @Column(name = "GM_YEAR_FIRST_MADE")
    private LocalDateTime yearFirstMade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "M_ID")
    private Manufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "MT_ID")
    private ModelType modelType;


}
