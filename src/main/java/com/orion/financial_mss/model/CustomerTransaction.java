package com.orion.financial_mss.model;
import javax.persistence.*;

@Table(name = "customer_transaction")
@Entity
public class CustomerTransaction {

    @Id
    @SequenceGenerator(
            name = "cust_trans_sequence",
            sequenceName = "cust_trans_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cust_trans_sequence"
    )

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "customer_name", nullable = false, columnDefinition = "TEXT")
    private String customerName;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "transaction_type_id")
    private Long transactionTypeId;

    @Column(name="amount", nullable = false, columnDefinition="Decimal(18,8) default '0'")
    private double amount;

    @Column(name = "account_number")
    private Long accountNumber;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }
    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }
}
