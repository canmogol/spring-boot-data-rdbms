package dev.canm.rdbms.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Manufacturer entity.
 */
@Data
@Entity
@NamedNativeQuery(name = "Manufacturer.getAllThatSellAcoustics",
    query = "SELECT m.id, m.name, m.foundedDate, m.averageYearlySales, m.location_id as headquarters_id "
        + "FROM Manufacturer m "
        + "LEFT JOIN Model mod ON (m.id = mod.manufacturer_id) "
        + "LEFT JOIN ModelType mt ON (mt.id = mod.modeltype_id) "
        + "WHERE (mt.name = ?)", resultClass = Manufacturer.class)
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "M_ID")
    private Long id;

    @Column(name = "M_NAME")
    private String name;

    @Column(name = "M_FOUNDED_DATE")
    private LocalDateTime foundedDate;

    @Column(name = "M_AVRG_YEAR_SALE")
    private BigDecimal averageYearlySales;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "M_ID")
    private List<GuitarModel> guitarModels = new ArrayList<>();

    @ManyToOne
    private Location headquarters;

}
