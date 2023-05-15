package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> bookSet;

    public ProductType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Product> bookSet) {
        this.bookSet = bookSet;
    }
}
