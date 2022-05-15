package edu.eci.arsw.model;

public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long cell;
    private String role;
    private String password;

    public User(){}

    public User(Integer userId, String firstName, String lastName, String email, Long cell , String role, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cell = cell;
        this.role = role;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, Long cell, String role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cell = cell;
        this.role = role;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getCell() {
        return cell;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
