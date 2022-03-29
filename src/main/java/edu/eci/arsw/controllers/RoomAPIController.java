package edu.eci.arsw.controllers;


import edu.eci.arsw.model.Room;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/v1/room")
public class RoomAPIController {

    @Autowired
    RoomService roomService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addRoom(@RequestBody Room room) {
        try {
            roomService.addRoom(room);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{type}/{userId}",method = RequestMethod.GET)
    public ResponseEntity<?> getTask(@PathVariable("type") String type, @PathVariable("userId") Integer userId){
        try {
            ArrayList<Room> rooms = roomService.getRoomByType(type, userId);
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
