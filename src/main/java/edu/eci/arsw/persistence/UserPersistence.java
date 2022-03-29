package edu.eci.arsw.persistence;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;

import java.util.ArrayList;

public interface UserPersistence {

    public void registerUser(User user);

    public User consultUser(String email);
}
