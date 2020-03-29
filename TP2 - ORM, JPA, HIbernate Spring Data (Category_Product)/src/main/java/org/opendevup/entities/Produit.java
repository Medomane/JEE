package org.opendevup.entities;

import java.io.Serializable; import javax.persistence.*;
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue
    private Long idProduit;
    private String designation;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "ID_CAT")
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String designation, double prix, Categorie categorie) {
        this.designation = designation;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Long getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}