package com.mock_ecommerce_app.service;

import com.mock_ecommerce_app.dtos.NewAddressDTO;
import com.mock_ecommerce_app.model.Address;
import com.mock_ecommerce_app.model.User;
import com.mock_ecommerce_app.repository.AddressRepository;
import com.mock_ecommerce_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public ResponseEntity<Optional<Address>> createNewAddress(NewAddressDTO newAddressDTO) {
        Address address = addressRepository.save(new Address(
                newAddressDTO.getAddressStreetName(),
                newAddressDTO.getAddressHouseNumber(),
                newAddressDTO.getAddressPostalCode()
        ));

        User user = userRepository.findById(newAddressDTO.getUserId()).orElse(null);
        if (user != null) {
            user.getAddresses().add(address);
            address.getUsers().add(user);
            addressRepository.save(address);
            return ResponseEntity.ok(Optional.of(address));
        }
        return ResponseEntity.badRequest().body(null);
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

    public Address addAddressToUser(User user, String streetName, String streetNumber, String postalCode) {
        Address address = new Address(streetName, streetNumber, postalCode);
        user.getAddresses().add(address);
        addressRepository.save(address);
        return address;
    }

    public Address updateAddress(Long id, Address newAddress) {

        return addressRepository.findById(id)
                .map(address -> {
                    if (newAddress.getAddressStreetName() != null) {
                        address.setAddressStreetName(newAddress.getAddressStreetName());
                    }
                    if (newAddress.getAddressHouseNumber() != null) {

                        address.setAddressHouseNumber(newAddress.getAddressHouseNumber());
                    }
                    if (newAddress.getAddressPostalCode() != null) {

                        address.setAddressPostalCode(newAddress.getAddressPostalCode());
                    }
                    return addressRepository.save(address);
                })
                .orElseGet(() -> {
                    return addressRepository.save(newAddress);
                });
    }

}
