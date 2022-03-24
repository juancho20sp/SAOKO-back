package edu.eci.arsw.controllers;

import edu.eci.arsw.model.Task;
import edu.eci.arsw.model.User;
import edu.eci.arsw.service.SaokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/v1")
public class SaokoAPIController {

    @Autowired
    SaokoService saokoService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            saokoService.registerUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/task",method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            System.out.println(task.getTaskName());
            saokoService.addTask(task);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/task/{idRoom}",method = RequestMethod.GET)
    public ResponseEntity<?> getTask(@PathVariable ("idRoom") Integer idRoom){
        try {
            ArrayList<ArrayList<Task>> tasks = saokoService.getTask(idRoom);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }



}
