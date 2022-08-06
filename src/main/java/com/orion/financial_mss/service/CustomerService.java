package com.orion.financial_mss.service;

import com.orion.financial_mss.interfaces.CustomerInterface;
import com.orion.financial_mss.model.Customer;
import com.orion.financial_mss.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class CustomerService implements CustomerInterface {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
}
