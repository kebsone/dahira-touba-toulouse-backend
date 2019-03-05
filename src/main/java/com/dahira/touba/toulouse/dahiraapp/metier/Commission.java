package com.dahira.touba.toulouse.dahiraapp.metier;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name ="DAHIRA_COMISSION")
public class Commission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Column(name = "description")
    @Size(max = 500)
    private String description;
    @Column(name = "description_complete")
    private String descriptionComplete;
    private String contact;

    //@OneToMany(mappedBy = "commission", fetch = FetchType.LAZY)
    //private Collection<Mission> missions;

    public Commission() {
    }

    public Commission(String titre, @Size(max = 2500) String description) {
        this.titre = titre;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getDescriptionComplete() {
        return descriptionComplete;
    }

    public void setDescriptionComplete(String descriptionComplete) {
        this.descriptionComplete = descriptionComplete;
    }

   // public Collection<Mission> getMissions() {
    //    return missions;
    //}

   // public void setMissions(Collection<Mission> missions) {
      //  this.missions = missions;
   // }
}
