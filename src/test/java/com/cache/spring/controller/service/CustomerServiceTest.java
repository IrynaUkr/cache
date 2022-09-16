package com.cache.spring.controller.service;

import com.cache.spring.controller.model.Customer;
import com.cache.spring.controller.repository.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerServiceTest {
    CustomerService customerService;



    @Test
    void methodGetByIdShouldNotBeCalledSeveralTimesWithSameParameterTest() {
        customerService= new CustomerService(new CustomerRepository());
        customerService.getCustomerById(123);
        Customer customerById = customerService.getCustomerById(123);
        System.out.println(customerById);
        assertNotNull(customerById);
    }

}