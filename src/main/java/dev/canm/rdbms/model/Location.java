package dev.canm.rdbms.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Location Entity.
 */
@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "L_ID")
    private Long id;

    @Column(name = "L_STATE")
    private String state;

    @Column(name = "L_COUNTRY")
    private String country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "L_ID")
    private List<Manufacturer> manufacturers = new ArrayList<>();

}
