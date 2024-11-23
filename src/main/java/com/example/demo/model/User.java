package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "username is required")
    @Size(min = 2, max = 100, message = "userName should be between 2 and 100 characters")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "email is required")
    @Email(message = "invalid email format")
    @Column(unique = true)
    private String email;


    @NotEmpty(message = "password is required")
    @Size(min = 2, max = 100, message = "product Name should be between 2 and 100 characters")
    private String password;
}
