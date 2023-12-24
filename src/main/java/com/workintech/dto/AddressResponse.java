package com.workintech.dto;

import com.workintech.entity.Account;
import com.workintech.entity.Address;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AddressResponse {

    private long id;
    private String street;
    private int no;
    private String city;
    private String country;
    private String description;

    private AddressResponse() {

    }

    private AddressResponse(long id, String street, int no, String city, String country, String description) {
        this.id = id;
        this.street = street;
        this.no = no;
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public static AddressResponse convert(Address address) {

        return new AddressResponse(address.getId(), address.getStreet(), address.getNo(),
                address.getCity(), address.getCountry(), address.getDescription());
    }

    public static List<AddressResponse> convert(List<Address> addresses) {

        List<AddressResponse> list = new ArrayList<>();
        addresses.forEach(address -> list.add(AddressResponse.convert(address)));
        return list;
    }
}
