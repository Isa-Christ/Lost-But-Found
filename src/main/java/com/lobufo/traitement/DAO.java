package com.lobufo.traitement;

import java.sql.Connection;
import com.lobufo.BD.BdConnection;
import com.lobufo.metier.Appareil;

public interface DAO {
    public final Connection connection = BdConnection.connect();

    public void ajouterBd(Appareil appareil);

}
