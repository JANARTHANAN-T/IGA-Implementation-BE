package com.baeldung.domain;

public class Step {
    private String id;
    private String name;
    private String description;
    private int priority;
    private String assignee;
    private String owner;
    private String processId;

    public Step(String id, String name, String description, int priority, String assignee, String owner, String processId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.owner = owner;
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
