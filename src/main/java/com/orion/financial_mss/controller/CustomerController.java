package com.orion.financial_mss.controller;

import com.orion.financial_mss.model.Customer;
import com.orion.financial_mss.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/")
    public List<Customer> customers() {
        return customerService.getCustomerList();
    }
}
