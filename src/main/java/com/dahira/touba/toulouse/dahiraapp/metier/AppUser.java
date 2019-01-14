package com.dahira.touba.toulouse.dahiraapp.metier;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String mail;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @Column
    @Size(max = 150)
    private String prenom;
    @Size(max=100)
    private String nom;
    private String telephone;

    private String genre;
    @Size(max=2500)
    private String adresse;

    // A chaque fois que je charge un user, je charge la liste des ces roles
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="dahira_mission")
    private Collection<Commission> commissions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="dahira_competent")
    private Collection<Competence> competences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Commission> getCommissions() {
        return commissions;
    }

    public void setCommissions(Collection<Commission> commissions) {
        this.commissions = commissions;
    }

    public Collection<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Collection<Competence> competences) {
        this.competences = competences;
    }

    public AppUser() {
    }

    public AppUser(Long id, String mail, String password, boolean actived, @Size(max = 150) String prenom, @Size(max = 100) String nom, String telephone, String genre, @Size(max = 2500) String adresse, Collection<AppRole> roles) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.actived = actived;
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.genre = genre;
        this.adresse = adresse;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", actived=" + actived +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", genre='" + genre + '\'' +
                ", adresse='" + adresse + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return actived == appUser.actived &&
                Objects.equals(id, appUser.id) &&
                Objects.equals(mail, appUser.mail) &&
                Objects.equals(password, appUser.password) &&
                Objects.equals(prenom, appUser.prenom) &&
                Objects.equals(nom, appUser.nom) &&
                Objects.equals(telephone, appUser.telephone) &&
                Objects.equals(genre, appUser.genre) &&
                Objects.equals(adresse, appUser.adresse) &&
                Objects.equals(roles, appUser.roles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mail, password, actived, prenom, nom, telephone, genre, adresse, roles);
    }
}
