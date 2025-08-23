package com.example.aestheticClinic.domain.entity;

import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.domain.objectValue.Roles;

import java.util.stream.Stream;

public class User {

    private String name;
    private Email email;
    private Roles role;
    private String password;

    public User(String name, Email email, String password, Roles role) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cant be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cant be null or empty");
        }
        if (email == null || email.getValue().isEmpty()) {
            throw new IllegalArgumentException("Email cant be null or empty");
        }
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;

    }


    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Roles getRole() {
        return role;
    }
}
