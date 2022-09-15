package com.cache.spring.controller.repository;

import com.cache.spring.controller.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customerList;

    private List<Customer> createListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Ann", "London", 123));
        customerList.add(new Customer("Tom", "New York", 345));
        return customerList;
    }


    public Customer getById(int id) {
        customerList = createListCustomer();
        return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}
