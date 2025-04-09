package com.lobufo.repertoire;

import java.util.ArrayList;
import java.util.List;

import com.lobufo.metier.Laptop;
import com.lobufo.metier.Appareil;

public class RepertoireLaptop implements Repertoire {
    List<Laptop> Laptops = new ArrayList<Laptop>();

    @Override
    public void ajouter(Appareil appareil){
        if (appareil instanceof Laptop) {
            Laptops.add((Laptop) appareil);
        } else {
            throw new IllegalArgumentException("Only Laptop instances can be added.");
        }
    }

    @Override
    public void supprimer (Appareil appareil){
        if (appareil instanceof Laptop) {
            Laptops.remove(appareil);
        } else {
            throw new IllegalArgumentException("Only Laptop instances can be removed.");
        }
    }

    public List<Laptop> getListLaptop(){
        return Laptops;
    }

    @Override
    public void modifierAppareil(String addresseMac, Appareil appareil ){

    }


}
