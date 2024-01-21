package com.example.java5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categories")
public class Category implements Serializable {
    @Id
    String id;
    String name;
    @OneToMany(mappedBy = "category")
    List<Product2> products;
}
