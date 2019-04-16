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
 * Model Entity.
 */
@Data
@Entity
public class ModelType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MT_ID")
    private Long id;

    @Column(name = "MT_NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MT_ID")
    private List<GuitarModel> guitarModels = new ArrayList<>();

}
