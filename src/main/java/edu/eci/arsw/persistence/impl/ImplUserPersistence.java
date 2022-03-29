package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.conectdb.CConexion;
import edu.eci.arsw.error.ExceptionLoginEmailPassword;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            sql = "SELECT * FROM DB_USER WHERE email ='"+user.getEmail()+"';";
            java.sql.ResultSet res = date.executeQuery(sql);
            if (res.next()) {
                user.setUserId(res.getInt("userid"));
            }
            System.out.println(toHexString(getSHA(user.getPassword())));
            sql = "INSERT INTO DB_PASSWORD (password, userId) VALUES ('"+ toHexString(getSHA(user.getPassword())) + "'," +user.getUserId()+");";
            date.execute(sql);
            date.close();
            System.out.println("Se añadio el usuario de forma correcta");
        } catch (SQLException e) {
            System.out.println("No se logro añadir el usuario: "+ e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        disconnectConnection();
    }

    @Override
    public User loginUser(User user) throws NoSuchAlgorithmException, ExceptionLoginEmailPassword {
        generateConnection();
        User userN = new User();
        try{
            java.sql.Statement  date = connection.createStatement();
            String sql = "SELECT * FROM DB_USER WHERE email ='"+user.getEmail()+"';";
            java.sql.ResultSet res = date.executeQuery(sql);

            if(res.next()) {
                userN.setUserId(res.getInt("userid"));
                userN.setFirstName(res.getString("firstname"));
                userN.setLastName(res.getString("lastname"));
                userN.setEmail(res.getString("email"));
                userN.setCell(res.getLong("cell"));
                userN.setRole(res.getString("role"));
            }

            if (!(user.getEmail().equals(userN.getEmail()))) {
                throw new ExceptionLoginEmailPassword("Correo o constraseña invalido");
            }

            sql = "SELECT * FROM DB_PASSWORD WHERE userId ="+userN.getUserId()+";";
            res = date.executeQuery(sql);

            if(res.next()) {
                userN.setPassword(res.getString("password"));
            }

            date.close();

        } catch(Exception e) {
            System.out.println("No se logro consultar el usuario: "+ e);
        }

        disconnectConnection();
        if(userN.getPassword().equals(toHexString(getSHA(user.getPassword())))) {
            return userN;
        } else {
            throw new ExceptionLoginEmailPassword("Correo o constraseña invalido");
        }
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

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
