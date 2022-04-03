package edu.eci.arsw.service.impl;

import edu.eci.arsw.error.ExceptionLoginEmailPassword;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.UserPersistence;
import edu.eci.arsw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class ImplUserService implements UserService {
    @Autowired
    UserPersistence userp = null;

    // $
    // public void registerUser(User user) {
    public User registerUser(User user) {
        return userp.registerUser(user);
    }

    public User loginUser(User user) throws ExceptionLoginEmailPassword, NoSuchAlgorithmException {return userp.loginUser(user); }
}
