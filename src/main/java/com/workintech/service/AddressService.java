package com.workintech.service;

import com.workintech.dto.AddressResponse;
import com.workintech.entity.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAll();
    AddressResponse findById(long id);
    AddressResponse save(Address address);
    AddressResponse delete(long id);
}
