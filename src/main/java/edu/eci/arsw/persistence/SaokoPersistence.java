package edu.eci.arsw.persistence;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;

import java.util.ArrayList;

public interface SaokoPersistence {

    public void registerUser(User user);

    public void addTask(Task task);

    public ArrayList<ArrayList<Task>> getTasks(Integer roomId);
}
