package com.example.demo.mvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @ManyToOne
    private Category category;

    @OneToMany (mappedBy = "product")
    private Set<ProductItem> productItemSet;

    private LocalDateTime createDate;

    public Product(String name, String description, Category category, LocalDateTime createDate) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.createDate = createDate;
    }
}
