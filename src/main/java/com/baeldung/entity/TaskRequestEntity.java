package com.baeldung.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task_request_entity", uniqueConstraints = {@UniqueConstraint(columnNames = {"task_req_id"})})
public class TaskRequestEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private String task_req_id;

    @Id
    @Column
    private String user_id;

    @Id
    @Column
    private String task_type;

    @Id
    @Column
    private String task_id;

    public TaskRequestEntity(String task_req_id, String user_id, String task_type, String task_id) {
        this.task_req_id = task_req_id;
        this.user_id = user_id;
        this.task_type = task_type;
        this.task_id = task_id;
    }

    public TaskRequestEntity() {

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }
}