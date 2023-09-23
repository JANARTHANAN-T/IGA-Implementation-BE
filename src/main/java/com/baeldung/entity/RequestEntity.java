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
    private String user_id;

    @Id
    @Column
    private String req_type;

    @Id
    @Column
    private String job_id;

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

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }
}
