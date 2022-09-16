package com.cache.spring.controller.service;

import com.cache.spring.controller.model.Customer;
import com.cache.spring.controller.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Cacheable("customers")
    public List<Customer> getAllCustomers() {
        LOGGER.info(() -> "Cacheable: service method get all customers was called");
        return repository.getAllCustomers();
    }

    @CachePut(value = "customer/{id}")
    public Customer getCustomerById(int id) {
        LOGGER.info(() -> "CachePut : service method get customer by Id was called");
        return repository.getById(id);
    }

    @CacheEvict(value = "customer", allEntries = true)
    public void deleteById(int id) {
        LOGGER.info(() -> "CacheEvict: service method delete customer by Id was called");
        repository.deleteCustomerByName(id);
    }
}


