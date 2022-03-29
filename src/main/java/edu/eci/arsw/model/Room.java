package edu.eci.arsw.model;

public class Room {
    private Integer roomID;
    private String roomName;
    private String roomType;
    private Integer userId;
    private Integer roomCode;


    public Room(){}

    public Room(Integer roomId, String roomName, String roomType, Integer userId){
        this.roomID = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.userId = userId;
        this.roomCode = generateCode(roomName);
    }

    public Room(Integer roomId, String roomName, String roomType, Integer userId, Integer roomCode){
        this.roomID = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.userId = userId;
        this.roomCode = roomCode;
    }



    private Integer generateCode(String roomName){
        return roomName.hashCode() * (int)Math.random()*(1000-1+1)+1;
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

    public Integer getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(Integer roomCode) {
        this.roomCode = roomCode;
    }
}
