package edu.eci.arsw.persistence;

import edu.eci.arsw.error.ExceptionLoginEmailPassword;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public interface UserPersistence {

    // $
    // public void registerUser(User user);
    public User registerUser(User user);

    public User loginUser(User user) throws NoSuchAlgorithmException, ExceptionLoginEmailPassword;
}
