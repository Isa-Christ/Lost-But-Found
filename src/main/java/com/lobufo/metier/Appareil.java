package com.lobufo.metier;

public class Appareil {

    private String marque;
    private String couleur;
    private String description;
    private String imagePath;

    public Appareil(String marque, String couleur, String description, String imagePath) {
        this.marque = marque;
        this.couleur = couleur;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    

}
