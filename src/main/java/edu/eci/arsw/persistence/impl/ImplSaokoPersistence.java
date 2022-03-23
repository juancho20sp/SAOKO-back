package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.conectdb.CConexion;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.SaokoPersistence;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
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
            String sql = "INSERT INTO DB_USER (firstName, lastName, email, role) VALUES ('"+ user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getRole().toUpperCase() +"');";
            date.execute(sql);
            date.close();
            System.out.println("Se añadio el usuario de forma correcta");
        } catch (SQLException e) {
            System.out.println("No se logro añadir el usuario: "+ e);
        }

        disconnectConnection();
    }

    @Override
    public void addTask(Task task) {
        System.out.println("saokoPersistence.addTask");
        generateConnection();

        try {
            java.sql.Statement  date = connection.createStatement();
            String sql = "INSERT INTO DB_TASK (taskName, status) VALUES ('"+ task.getTaskName() + "', 'NEW ');";
            date.execute(sql);
            date.close();
            System.out.println("Se añadio la tarea");
        } catch (SQLException e) {
            System.out.println("No se logro añadir la tarea: "+ e);
        }
        disconnectConnection();
    }

    @Override
    public void getTasks(Integer roomId) {
        System.out.println("saokoPersistence.gettask");
        generateConnection();

        try {
            java.sql.Statement  date = connection.createStatement();
            ResultSet rs = date.executeQuery("SELECT * FROM DB_TASK;");
            System.out.println(rs);
            while (rs.next()) {
                String lastName = rs.getString("Lname");
                System.out.println(lastName + "\n");
            }

            //date.execute(sql);
            date.close();
            //System.out.println("Se añadio la tarea");
        } catch (SQLException e) {
            System.out.println("No se logro añadir la tarea: "+ e);
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
