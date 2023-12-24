package com.workintech.service;

import com.workintech.dto.AddressResponse;
import com.workintech.entity.Address;
import com.workintech.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressResponse> findAll() {
        return AddressResponse.convert(addressRepository.findAll());
    }

    @Override
    public AddressResponse findById(long id) {

        Optional<Address> foundAddress = addressRepository.findById(id);

        if(foundAddress.isPresent()) {
            return AddressResponse.convert(foundAddress.get());
        }

        // [TODO] throw exception
        return null;
    }

    @Override
    public AddressResponse save(Address address) {
        return AddressResponse.convert(addressRepository.save(address));
    }

    @Override
    public AddressResponse delete(long id) {

        AddressResponse addressResponse = findById(id);
        addressRepository.deleteById(addressResponse.getId());
        return addressResponse;
    }
}
