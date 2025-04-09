package com.lobufo.traitement;

import com.lobufo.metier.Laptop;

import java.sql.PreparedStatement;

import com.lobufo.BD.BdConnection;
import com.lobufo.metier.Appareil;

public class LaptopDAO implements DAO{
    
    public void ajouterBd (Appareil appareil){
        if(!( appareil instanceof Laptop)){
            throw new IllegalArgumentException("seuls les laptops peuvent etre ajoutes");
        }else{
            Laptop laptop = (Laptop) appareil;
            String s = "INSERT INTO LAPTOP (Marque, Couleur, Description, Tactile, NumeroSerie, Longueur, Largeur) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement prstmt = BdConnection.connect().prepareStatement(s)) {
                prstmt.setString(1, laptop.getMarque());
                prstmt.setString(2, laptop.getCouleur());
                prstmt.setString(3, laptop.getDescription());
                prstmt.setBoolean(4, laptop.isTactile());
                prstmt.setString(5, laptop.getNumeroSerie());
                prstmt.setDouble(6, laptop.getLongueur());
                prstmt.setDouble(7, laptop.getLargeur());
                prstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Erreur lors de l'ajout du laptop à la base de données");
            }
            
        }
    }
}
