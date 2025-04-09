package com.lobufo.repertoire;

import java.util.List;
import java.util.ArrayList;

import com.lobufo.metier.Appareil;
import com.lobufo.metier.Telephone;


public class RepertoireTelephone implements Repertoire{

    List<Telephone> telephones = new ArrayList<Telephone>();

    @Override
    public void ajouter(Appareil telephone){
        Telephone tel = (Telephone) telephone;
        telephones.add(tel);
    }
    
    public void supprimer (Appareil appareil){
        if (appareil instanceof Telephone){
            telephones.remove(appareil);
        }else{
            throw new IllegalArgumentException("Only Telephone instances can be removed.");
        }
    }

    @Override
    public void modifierAppareil(String imei, Appareil newTelephone) {
        if (!(newTelephone instanceof Telephone)) {
            throw new IllegalArgumentException("Only Telephone instances can be modified.");
        }
        Telephone newTel = (Telephone) newTelephone;
        for(Telephone telephone : telephones){
            if(telephone.getImei().equals(imei)){
                telephone.setImei(newTel.getImei());
                telephone.setCouleur(newTel.getCouleur());
                telephone.setDescription(newTel.getDescription());
                telephone.setMarque(newTel.getMarque());
            }
        }
        
    }

    public List<Telephone> getListTelephone(){
        return telephones;
    }

    
}
