package com.park.backend.restful.service.backendrestfulservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
public class Person {

    @Id
    private String id;
    @Indexed
    private String username;
    private String password;
    private String nickName;
    private Status status;
    private Collection<String> role;

    public Person() {
    }

    public Person(String id, String username, String password, String nickName, Status status, Collection<String> role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.status = status;
        this.role = role;
    }

    public Person(Person person) {
        this.id = person.id;
        this.username = person.username;
        this.password = person.password;
        this.nickName = person.nickName;
        this.status = person.status;
        this.role = person.role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Collection<String> getRole() {
        return role;
    }

    public void setRole(Collection<String> role) {
        this.role = role;
    }
}
