package com.baeldung.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_entity", uniqueConstraints = {@UniqueConstraint(columnNames = {"request_id"})})
public class RequestEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private String request_id;
    
    @Id
    @Column
    private String owner;

    @Id
    @Column
    private String user_id;

    @Id
    @Column
    private String req_type;

    @Id
    @Column
    private String activity_id;

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReq_type() {
        return req_type;
    }

    public void setReq_type(String req_type) {
        this.req_type = req_type;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String job_id) {
        this.activity_id = job_id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
