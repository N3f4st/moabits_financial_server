package com.orion.financial_mss.repository;

import com.orion.financial_mss.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
