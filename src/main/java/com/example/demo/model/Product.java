package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "name is required")
    @Size(min = 2, max = 100, message = "product Name should be between 2 and 100 characters")
    @Column(unique = true)
    private String name;

    @NotEmpty(message = "categorie is required")
    @Column(name="categorie")
    private String categorie;

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getCategorie() {
        return categorie;
    }
}
