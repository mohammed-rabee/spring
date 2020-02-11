package com.example.demo.mvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int id;
    private String firstName;
    private String lastName;
    private String mobile;

    @OneToMany (mappedBy = "client")
    private Set<Sale> sales;

    public Client(String firstName, String lastName, String mobile, Set<Sale> sales) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.sales = sales;
    }
}
