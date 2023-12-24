package com.workintech.controller;

import com.workintech.dto.AddressResponse;
import com.workintech.entity.Address;
import com.workintech.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final private AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping
    public List<AddressResponse> findAll() {
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable long id) {
        return addressService.findById(id);
    }
    @PostMapping
    public AddressResponse save(@RequestBody Address address) {
        return addressService.save(address);
    }
    @PutMapping("/{id}")
    public AddressResponse update(@PathVariable long id , @RequestBody Address address) {
        address.setId(id);
        return addressService.save(address);
    }
    @DeleteMapping("/{id}")
    public AddressResponse delete(@PathVariable long id) {
        return addressService.delete(id);
    }
}
