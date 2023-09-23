package com.baeldung.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_entity", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})
public class UserEntity {
    @Id
    @Column
    private String user_id;

    @Id
    @Column
    private String role;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
