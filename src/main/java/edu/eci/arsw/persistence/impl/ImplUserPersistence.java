package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.conectdb.CConexion;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class ImplUserPersistence implements edu.eci.arsw.persistence.UserPersistence {

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

    @Override
    public User consultUser(String email) {
        generateConnection();
        User user = new User();
        try{
            java.sql.Statement  date = connection.createStatement();
            String sql = "SELECT * FROM DB_USER WHERE email LIKE '"+email+"%';";
            System.out.println(email);
            java.sql.ResultSet res = date.executeQuery(sql);

            if(res.next()) {
                user.setUserId(res.getInt("userid"));
                user.setFirstName(res.getString("firstname"));
                user.setLastName(res.getString("lastname"));
                user.setEmail(res.getString("email"));
                user.setCell(res.getLong("cell"));
                user.setRole(res.getString("role"));
            }
        } catch(Exception e) {
            System.out.println("No se logro consultar el usuario: "+ e);
        }

        disconnectConnection();
        return user;
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
