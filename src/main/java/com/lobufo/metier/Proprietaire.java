package com.lobufo.metier;

public class Proprietaire extends Visiteur{

    private String password;

    public Proprietaire(String nom, String prenom, String email, String password) {
        super(nom, prenom, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
