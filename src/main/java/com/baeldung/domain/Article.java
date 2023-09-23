package com.baeldung.domain;

public class Article {

    private String id;
    private String userId;
    private String email;
    private String role;
    private String author;
    private String url;
    private String step;

    public Article() {
    }

    public Article(String author, String url) {
        this.author = author;
        this.url = url;
    }

    public Article(String id, String author, String url) {
        this.id = id;
        this.author = author;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public Article(String id, String userId, String url, String role, String author, String email) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.role = role;
        this.author = author;
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return ("[" + this.author + " " + this.url + "]");
    }

}
