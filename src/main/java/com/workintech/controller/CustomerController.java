package com.workintech.controller;

import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Customer;
import com.workintech.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    final private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable long id) {
        return customerService.findById(id);
    }
    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable long id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public CustomerResponse delete(@PathVariable long id) {
        return customerService.delete(id);
    }





}
