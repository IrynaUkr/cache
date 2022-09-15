package com.cache.spring.controller.service;

import com.cache.spring.controller.model.Customer;
import com.cache.spring.controller.repository.CustomerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerRepository repository;

    @Cacheable("customer")
    public Customer getCustomerById(int id) {
        System.out.println("method was called");
        repository = new CustomerRepository();
        Customer byId = repository.getById(id);
        return byId;
    }
}


