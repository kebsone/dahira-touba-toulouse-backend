package com.dahira.touba.toulouse.dahiraapp.metier;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Poste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="libelle_poste")
    private String libelle;
    @Column(name="numero_ordre")
    private Integer numeroOrdre;
    @ManyToOne
    private Commission commission;

    public Poste() {
    }

    public Poste(Long id, String libelle, Integer numeroOrdre, Commission commission) {
        this.id = id;
        this.libelle = libelle;
        this.numeroOrdre = numeroOrdre;
        this.commission = commission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(Integer numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }
}
