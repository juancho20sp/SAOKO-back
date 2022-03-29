package edu.eci.arsw.service.impl;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.persistence.TaskPersistence;
import edu.eci.arsw.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImplTaskService implements TaskService {

    @Autowired
    TaskPersistence taskp = null;
    @Override
    public void addTask(Task task){taskp.addTask(task);}

    @Override
    public ArrayList<ArrayList<Task>> getTask(Integer roomId) {return taskp.getTasks(roomId);}

    @Override
    public void deleteTask(Integer taskId) { taskp.deleteTask(taskId);}
}
