package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.conectdb.CConexion;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.persistence.TaskPersistence;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Service
public class ImplTaskPersistence implements TaskPersistence {

    private CConexion cConexion = new CConexion();
    private Connection connection = null;

    @Override
    public void addTask(Task task) {
        System.out.println("saokoPersistence.addTask");
        generateConnection();

        try {
            java.sql.Statement  date = connection.createStatement();
            String sql = "INSERT INTO DB_TASK (taskName, status) VALUES ('"+ task.getTaskName() + "', 'TO DO');";
            date.execute(sql);
            date.close();
            System.out.println("Se añadio la tarea");
        } catch (SQLException e) {
            System.out.println("No se logro añadir la tarea: "+ e);
        }
        disconnectConnection();
    }




    @Override
    public ArrayList<ArrayList<Task>> getTasks(Integer roomId) {
        String [] taskStatus = new String [] {"TO DO", "IN PROGRESS", "DONE"};
        System.out.println("saokoPersistence.gettask");
        generateConnection();

        try {
            ArrayList<ArrayList<Task>> finalList = new ArrayList<>();
            for(int i = 0; i <= 2; i++){
                System.out.println(taskStatus[i]);
                java.sql.Statement  date = connection.createStatement();
                ResultSet rs = date.executeQuery("SELECT * FROM DB_TASK WHERE status = '" + taskStatus[i]+ "' AND roomId =" + roomId + " ;");
                ArrayList<Task> tasks = new ArrayList<>();
                while (rs.next()) {
                    int taskId = rs.getInt("taskid");
                    String taskName = rs.getString("taskname");
                    String status = rs.getString("status");

                    System.out.println("ID: " + taskId + "\n" +
                            "Name: " + taskName + "\n" +
                            "Status: " + status + "\n");

                    tasks.add(new Task(taskId, taskName, status));
                }

                finalList.add(tasks);

                date.close();

            }

            disconnectConnection();
            return finalList;


        } catch (SQLException e) {
            System.out.println("No se encuentran tareas: "+ e);
        }


        return null;
    }

    @Override
    public void deleteTask(Integer taskId) {
        System.out.println("saokoPersistence.deleteTask");
        generateConnection();

        try {
            java.sql.Statement  date = connection.createStatement();
            String sql = "DELETE FROM DB_TASK WHERE taskId =" + taskId + ";";
            date.execute(sql);
            date.close();
            System.out.println("Se eliminó la tarea");
        } catch (SQLException e) {
            System.out.println("No se logro eliminar la tarea: "+ e);
        }
        disconnectConnection();

    }

    private void generateConnection() {
        connection = cConexion.conecDB();
    }

    private void disconnectConnection() {
        try {
            connection.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion con la db: "+e);
        }
    }
}
