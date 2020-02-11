package com.example.demo.mvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Transactional
public class Sale {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime creationDate;

    @ManyToOne
    private Client client;

    @OneToMany (mappedBy = "sale")
    private Set<ProductItem> productItemSet;

    private String seller;
    private double total;

    public Sale(LocalDateTime creationDate, Client client, Set<ProductItem> productItemSet, String seller, double total) {
        this.creationDate = creationDate;
        this.client = client;
        this.productItemSet = productItemSet;
        this.seller = seller;
        this.total = total;
    }
}
