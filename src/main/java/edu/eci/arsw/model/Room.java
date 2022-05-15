package edu.eci.arsw.model;

public class Room {
    private Integer roomID;
    private String roomName;
    private String roomType; // CHAT | TASK
    private Integer userId;
    private String roomCode; // $ -> pasar a string


    public Room(){}


    public Room(Integer roomId, String roomName, String roomType, Integer userId, String roomCode){
        this.roomID = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.userId = userId;
        this.roomCode = roomCode;
    }


    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }
}
