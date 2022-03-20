package edu.eci.arsw.controllers;

import edu.eci.arsw.model.User;
import edu.eci.arsw.service.SaokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
