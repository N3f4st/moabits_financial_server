package com.orion.financial_mss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table(name = "customer")
@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "shortName", nullable = false, columnDefinition = "TEXT")
    private String shortName;

    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String fullName;

    @Column(name = "credit_limit", nullable = false, columnDefinition = "TEXT")
    private double creditLimit;


    public Customer(String shortName, String fullName, double creditLimit) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.creditLimit = creditLimit;
    }

}
