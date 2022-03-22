package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.conectdb.CConexion;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.SaokoPersistence;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

@Service
public class ImplSaokoPersistence implements SaokoPersistence {

    private CConexion cConexion = new CConexion();
    private Connection connection = null;

    @Override
    public void registerUser(User user) {
        generateConnection();

        try {
            java.sql.Statement  date = connection.createStatement();
            String sql = "INSERT INTO DB_USER (firstName, lastName, email, cell, role) VALUES ('"+ user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getCell() + "','" + user.getRole().toUpperCase() +"');";
            date.execute(sql);
            date.close();
            System.out.println("Se añadio el usuario de forma correcta");
        } catch (SQLException e) {
            System.out.println("No se logro añadir el usuario: "+ e);
        }

        disconnectConnection();
    }

    private void generateConnection() {
        connection = cConexion.conecDB();
    }

    private void disconnectConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion con la db: "+e);
        }
    }
}
