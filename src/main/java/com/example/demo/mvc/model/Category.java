package com.example.demo.mvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int id;

    @OneToMany (mappedBy = "category")
    private Set<Product> product;

    private String name;
}
