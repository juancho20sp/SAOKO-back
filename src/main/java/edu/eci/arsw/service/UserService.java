package edu.eci.arsw.service;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.impl.ImplUserPersistence;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public void registerUser(User user);
}
