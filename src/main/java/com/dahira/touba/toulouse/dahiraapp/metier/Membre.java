package com.dahira.touba.toulouse.dahiraapp.metier;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import  org.hibernate.annotations.Parameter;


@Entity
@Table(name = "DAHIRA_MEMBRE")
public class Membre implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAHIRA_MEMBRE_SEQ")
    @GenericGenerator(
            name = "DAHIRA_MEMBRE_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "DAHIRA_MEMBRE_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")}
    )
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    @Size(max = 10)
    private String telephone;

    @Email
    @Column(name="mail")
    private String mail;

    @Column(name="profession")
    @Size(max = 2000)
    private String metier;


    @Column(name="commission", nullable = true)
    private String commision;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pubicite_commerce_id")
    private List<PubliciteCommerce> publiciteCommerceList;

    public String getCommision() {
        return commision;
    }

    public void setCommision(String commision) {
        this.commision = commision;
    }


    public Membre() {
    }

    public Membre(String nom, String prenom, String telephone, String mail, String metier) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.metier = metier;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }

    public String getMetier() {
        return metier;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }
}
