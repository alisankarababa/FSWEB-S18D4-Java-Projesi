package com.workintech.service;

import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<CustomerResponse> findAll();
    CustomerResponse findById(long id);
    CustomerResponse save(Customer customer);
    CustomerResponse delete(long id);
}
