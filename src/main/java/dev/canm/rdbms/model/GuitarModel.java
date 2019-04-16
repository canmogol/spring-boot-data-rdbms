package dev.canm.rdbms.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GuitarModel Entity.
 */
@Data
@Entity
@NamedQuery(name = "GuitarModel.findAllGuitarModelsByType",
    query = "select m from GuitarModel m where m.modelType.name = :name")
public class GuitarModel {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private int frets;
    private String woodType;
    private LocalDateTime yearFirstMade;

    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne
    private ModelType modelType;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
