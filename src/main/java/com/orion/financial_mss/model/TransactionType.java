package com.orion.financial_mss.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "transaction_type")
@Entity(name = "transaction_type")
public class TransactionType {

    public TransactionType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @SequenceGenerator(
            name = "transaction_type_sequence",
            sequenceName = "transaction_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_type_sequence"
    )
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
