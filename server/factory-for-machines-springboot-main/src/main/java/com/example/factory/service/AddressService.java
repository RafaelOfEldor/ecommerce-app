package com.example.factory.service;

import com.example.factory.model.Address;
import com.example.factory.model.Customer;
import com.example.factory.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address Address) {
        return addressRepository.save(Address);
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getAddressesPageable(int pageNumber) {
        return addressRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public void deleteAddress(Long id) { addressRepository.deleteById(id);}

    public Address addAddressToCustomer(Customer customer, String streetName, String streetNumber) {
        Address address = new Address(streetName, streetNumber);
        customer.getAddresses().add(address);
        addressRepository.save(address);
        return address;
    }

    public Address updateAddress(Long id, Address newAddress) {

        return addressRepository.findById(id)
                .map(address -> {
                    if (newAddress.getAddressStreetName() != null) {
                        address.setAddressStreetName(newAddress.getAddressStreetName());
                    }
                    if (newAddress.getAddressStreetNameNumber() != null) {

                        address.setAddressStreetNameNumber(newAddress.getAddressStreetNameNumber());
                    }
                    return addressRepository.save(address);
                })
                .orElseGet(() -> {
                    return addressRepository.save(newAddress);
                });
    }

}
