package com.adrar.h2exemple.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "livre")
public class Livre {

    /*---------------------------------------
                  Attributs
    ---------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titre", nullable = false, length = 50)
    private String titre;

    @Column(name="content", nullable = false, length = 255)
    private String description;

    @Column(name="genres", length = 50)
    private String genres;

    @Column(name="auteur", length = 50)
    private String auteur;

    @Column(name="maison_edition", length = 50)
    private String maisonEdition;

    @Column(name="date_publication", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePublication;


    /*---------------------------------------
                  Constructeurs
    ---------------------------------------*/
    public Livre() {}

    public Livre(String titre, String description, Date datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    /*---------------------------------------
                 Getters et Setters
    ---------------------------------------*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(String maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    /*---------------------------------------
                  Méthodes
    ---------------------------------------*/

    @Override
    public String toString() {
        return "Livre{" +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}
