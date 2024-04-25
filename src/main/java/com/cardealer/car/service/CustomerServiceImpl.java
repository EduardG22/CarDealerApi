package com.cardealer.car.service;

import com.cardealer.car.exceptions.EntityNotFoundException;
import com.cardealer.car.entity.Customer;
import com.cardealer.car.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
       return unwrapCustomer(customer, id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    static Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Customer.class);
    }
}
