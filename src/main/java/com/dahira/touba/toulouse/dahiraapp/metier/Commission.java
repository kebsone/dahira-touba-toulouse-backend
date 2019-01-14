package com.dahira.touba.toulouse.dahiraapp.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name ="DAHIRA_COMISSION")
public class Commission implements Serializable {
    @Id
    private String titre;
    @Column(name = "description")
    @Size(max = 2500)
    private String description;

    public Commission() {
    }

    public Commission(String titre, @Size(max = 2500) String description) {
        this.titre = titre;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
