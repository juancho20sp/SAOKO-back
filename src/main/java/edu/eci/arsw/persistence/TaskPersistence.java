package edu.eci.arsw.persistence;

import edu.eci.arsw.model.Task;

import java.util.ArrayList;

public interface TaskPersistence {
    public void addTask(Task task);

    public ArrayList<ArrayList<Task>> getTasks(Integer roomId);

    public void deleteTask(Integer taskId);

}
