package edu.eci.arsw.controllers;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/task")
public class TaskAPIController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            System.out.println(task.getTaskName());
            taskService.addTask(task);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{roomId}",method = RequestMethod.GET)
    public ResponseEntity<?> getTask(@PathVariable("roomId") Integer roomId){
        try {
            ArrayList<ArrayList<Task>> tasks = taskService.getTask(roomId);
                return new ResponseEntity<>(tasks, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{taskId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") Integer taskId){
        try {
            taskService.deleteTask(taskId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


}
