package com.workintech.dto;


import com.workintech.entity.Address;
import com.workintech.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CustomerResponse{

    long id;
    String firstName;
    String lastName;
    String email;
    double salary;
    AddressResponse addressResponse;

    private CustomerResponse() {

    }

    private CustomerResponse(long id, String firstName, String lastName, String email, double salary, AddressResponse addressResponse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.addressResponse = addressResponse;
    }

    public static CustomerResponse convert(Customer customer) {

        return new CustomerResponse(customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getEmail(), customer.getSalary(), AddressResponse.convert(customer.getAddress()));
    }

    public static List<CustomerResponse> convert(List<Customer> customers) {

        List<CustomerResponse> list = new ArrayList<>();
        customers.forEach(customer -> list.add(CustomerResponse.convert(customer)));
        return list;
    }


}
