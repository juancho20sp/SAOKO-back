package edu.eci.arsw.persistence;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;

public interface SaokoPersistence {

    public void registerUser(User user);

    public void addTask(Task task);

    public void getTasks(Integer roomId);
}
