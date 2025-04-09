package com.lobufo.repertoire;

import com.lobufo.metier.Appareil;

interface Repertoire {

    public void ajouter(Appareil appareil);

    public void supprimer (Appareil appareil);

    public void modifierAppareil(String addresseMac, Appareil newAppareil);

}
