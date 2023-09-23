package com.baeldung.models;

public class ReviewRequestObject {
    private String userId;
    private String taskId;
    private String description;
    private String req_type;

    public ReviewRequestObject() {
    }

    public ReviewRequestObject(String userId, String taskId, String description, String req_type) {
        this.userId = userId;
        this.taskId = taskId;
        this.description = description;
        this.req_type = req_type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReq_type() {
        return req_type;
    }

    public void setReq_type(String req_type) {
        this.req_type = req_type;
    }
}
