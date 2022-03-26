package edu.eci.arsw.service;

import edu.eci.arsw.model.Task;

import java.util.ArrayList;

public interface TaskService {

    public void addTask(Task task);

    public ArrayList<ArrayList<Task>> getTask(Integer roomId) ;
}
