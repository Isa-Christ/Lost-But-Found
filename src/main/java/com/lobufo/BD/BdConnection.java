package com.lobufo.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnection {

    private static String url = "jdbc:mysql://localhost:3306/APPAREIL";
    private static String user = "isahime";
    private static String password = "Is@enspy43";
    private static Connection connection ;

    public static Connection connect(){
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    
}
