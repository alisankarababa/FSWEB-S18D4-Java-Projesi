package com.workintech.service;

import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Customer;
import com.workintech.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponse> findAll() {
        return CustomerResponse.convert(customerRepository.findAll());
    }

    @Override
    public CustomerResponse findById(long id) {

        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if(foundCustomer.isPresent()) {
            return CustomerResponse.convert(foundCustomer.get());
        }

        //TODO throw exception
        return null;
    }

    @Override
    public CustomerResponse save(Customer address) {
        return CustomerResponse.convert(customerRepository.save(address));
    }

    @Override
    public CustomerResponse delete(long id) {

        CustomerResponse customerResponse = findById(id);
        customerRepository.deleteById(customerResponse.getId());
        return customerResponse;
    }
}