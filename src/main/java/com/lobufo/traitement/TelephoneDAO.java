package com.lobufo.traitement;

import java.sql.PreparedStatement;
import com.lobufo.BD.BdConnection;

import com.lobufo.metier.Appareil;
import com.lobufo.metier.Telephone;

public class TelephoneDAO {
    public void ajouterBd(Appareil appareil) {
        if (!(appareil instanceof Telephone)) {
            throw new IllegalArgumentException("seuls les téléphones peuvent être ajoutés");
        } else {
            Telephone telephone = (Telephone) appareil;
            String s = "INSERT INTO TELEPHONE (Marque, Couleur, Description, IMEI) VALUES (?, ?, ?, ?)";
            try (PreparedStatement prstmt = BdConnection.connect().prepareStatement(s)) {
            prstmt.setString(1, telephone.getMarque());
            prstmt.setString(2, telephone.getCouleur());
            prstmt.setString(3, telephone.getDescription());
            prstmt.setString(4, telephone.getImei());
            prstmt.executeUpdate();
            } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'ajout du téléphone à la base de données");
            }
        }
    }
}
