package edu.eci.arsw.service;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.SaokoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaokoService {

    @Autowired
    SaokoPersistence ss=null;

    public void registerUser(User user) {
        ss.registerUser(user);
    }


    public void addTask(Task task) {ss.addTask(task);}

    public void getTask() {ss.getTasks(000);}
}
