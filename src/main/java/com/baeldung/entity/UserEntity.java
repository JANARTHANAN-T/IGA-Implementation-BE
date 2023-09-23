package com.baeldung.entity;

import com.baeldung.models.UserModel;
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

    @Id
    @Column
    private String email;

    public UserEntity (UserModel userModel){
        this.email = userModel.getEmail();
        this.user_id = userModel.getUser_id();
        this.role = userModel.getRole();
    }

    public UserEntity(){
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
