package com.dahira.touba.toulouse.dahiraapp.Utils;

public class AppUserForm {
    private String prenom;
    private String nom;
    private String genre;
    private String telephone;
    private String adresse;
    private String mail;
    private String password;
    private String confirmedPassword;

    public AppUserForm() {
    }

    public AppUserForm(String prenom, String nom, String genre, String telephone, String adresse, String mail, String password, String confirmedPassword) {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.telephone = telephone;
        this.adresse = adresse;
        this.mail = mail;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public AppUserForm(String prenom, String nom, String genre, String telephone, String adresse, String mail) {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.telephone = telephone;
        this.adresse = adresse;
        this.mail = mail;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
