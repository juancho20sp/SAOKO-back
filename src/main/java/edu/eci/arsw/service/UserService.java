package edu.eci.arsw.service;

import edu.eci.arsw.error.ExceptionLoginEmailPassword;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.impl.ImplUserPersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    // $
    // public void registerUser(User user);
    public User registerUser(User user);

    public User loginUser(User user) throws ExceptionLoginEmailPassword, NoSuchAlgorithmException;
}
