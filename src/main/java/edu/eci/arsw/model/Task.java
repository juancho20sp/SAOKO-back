package edu.eci.arsw.model;

public class Task {
    private Integer taskId;
    private String taskName;
    private String status;

    public Task(){}

    public Task(String taskName){
        this.taskName = taskName;
        this.status = "NEW";
    }
    public Task(Integer taskId, String taskName, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }


    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
