package edu.eci.arsw.service.impl;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.UserPersistence;
import edu.eci.arsw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplUserService implements UserService {
    @Autowired
    UserPersistence userp = null;

    public void registerUser(User user) {
        userp.registerUser(user);
    }
}
