package com.dahira.touba.toulouse.dahiraapp.metier;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "dahira_mission")
public class Mission implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser appUser;
    @Id
    @ManyToOne
    @JoinColumn(name="commission_id")
    private Commission commission;

    @Id
    @ManyToOne
    @JoinColumn(name="poste_id")
    private Poste poste;



    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
}
