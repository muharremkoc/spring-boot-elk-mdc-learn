package com.spring.userservice.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Boolean isDummy=false;

    public User() {
    }

    public User(int id, String name, Boolean isDummy) {
        this.id = id;
        this.name = name;
        this.isDummy = isDummy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDummy() {
        return isDummy;
    }

    public void setDummy(Boolean dummy) {
        isDummy = dummy;
    }
}
