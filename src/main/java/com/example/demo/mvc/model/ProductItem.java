package com.example.demo.mvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ProductItem {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Sale sale;

    private double itemPrice;

    private int quantity;

    public ProductItem(Product product, Sale sale, double itemPrice, int quantity) {
        this.product = product;
        this.sale = sale;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }
}
