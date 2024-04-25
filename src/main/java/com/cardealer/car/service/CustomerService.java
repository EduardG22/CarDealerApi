package com.cardealer.car.service;

import com.cardealer.car.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    List<Customer> getAllCustomer();
}
