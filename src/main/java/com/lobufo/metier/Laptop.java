package com.lobufo.metier;

public class Laptop extends Appareil{
    private boolean tactile;
    private String numeroSerie;
    private int longueur;
    private int largeur;
    
    public Laptop(String marque, String couleur, String description, String imagePath,
                  boolean tactile, String numeroSerie, int longueur, int largeur) {
        super(marque, couleur, description, imagePath);
        this.tactile = tactile;
        this.numeroSerie = numeroSerie;
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public boolean isTactile() {
        return tactile;
    }

    public void setTactile(boolean tactile) {
        this.tactile = tactile;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    
}
