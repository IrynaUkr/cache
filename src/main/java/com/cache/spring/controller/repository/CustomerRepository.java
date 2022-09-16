package com.cache.spring.controller.repository;

import com.cache.spring.controller.model.Customer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepository.class);

    private final List<Customer> customerList= createListCustomer();

    private List<Customer> createListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Ann", "London", 123));
        customerList.add(new Customer("Tom", "New York", 345));
        return customerList;
    }


    public Customer getById(int id) {
        LOGGER.info(()-> "method get by Id in repository was called ");
        return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public List<Customer> getAllCustomers() {
        LOGGER.info(()-> "method get All customers in repository was called ");
        return customerList;
    }

    public void deleteCustomerByName(int id) {
        LOGGER.info(()-> "method delete by Id in repository was called ");
        Customer customerToDelete = customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findAny()
                .orElseThrow(RuntimeException::new);
        customerList.remove(customerToDelete);
    }
}
