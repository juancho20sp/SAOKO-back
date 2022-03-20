package edu.eci.arsw.conectdb;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class CConexion {

    private Connection connection = null;

    private String user = "wiyavrpvzlkqsg";
    private String password = "f9b8391e746a8738673c354655d811d4c080092b962cf2da0dc9cfb96f736711";
    private String db = "d69g13tbph2ps0";
    private String host = "ec2-35-175-68-90.compute-1.amazonaws.com";

    public Connection conecDB() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://"+ host +":5432/"+ db, user, password);
            System.out.println("Se conecto correctamente a l base de datos");

        }catch (Exception e) {
            System.out.println("Error al conectar a la base de datos, error: "+ e);
        }
        return connection;
    }
}
