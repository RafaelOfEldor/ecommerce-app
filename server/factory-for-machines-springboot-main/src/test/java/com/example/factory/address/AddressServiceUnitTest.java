package com.example.factory.address;


import com.example.factory.model.Address;
import com.example.factory.repository.AddressRepository;
import com.example.factory.service.AddressService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AddressServiceUnitTest {

    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;


    @Test
    void shouldFetchAllAddresss(){

        List<Address> addressList = List.of(new Address(), new Address());

        when(addressRepository.findAll()).thenReturn(addressList);

        assert addressService.getAddresses().size() == 2;
    }

    @Test
    void shouldAddAddress(){
        Address address = new Address("MyStreet", "123");

        when(addressRepository.save(address)).thenReturn(address);

        assert addressService.addAddress(address).getAddressStreetName().equals("MyStreet");
        assert addressService.addAddress(address).getAddressStreetNameNumber().equals("123");
    }

    @Test
    void shouldFetchAddressById(){
        Optional<Address> address = Optional.of(new Address("MyStreet", "123"));

        Mockito.<Optional<Address>>when(addressRepository.findById(address.get().getAddressId())).thenReturn(address);

        assert addressService.getAddressById(address.get().getAddressId()).getAddressStreetName().equals("MyStreet");
        assert addressService.getAddressById(address.get().getAddressId()).getAddressStreetNameNumber().equals("123");
    }

    @Test
    void shouldUpdateAddress() {
        Address existingAddress = new Address("MyStreet", "123");
        when(addressRepository.save(existingAddress)).thenReturn(existingAddress);

        Address updatedAddress = new Address("MyNewStreet", "321");
        Optional<Address> optionalUpdatedAddress = Optional.of(updatedAddress);

        when(addressRepository.findById(5L)).thenReturn(optionalUpdatedAddress);
        when(addressRepository.save(updatedAddress)).thenReturn(updatedAddress);

        assert  addressService.updateAddress(5L, updatedAddress).getAddressStreetName().equals("MyNewStreet");
        assert  addressService.updateAddress(5L, updatedAddress).getAddressStreetNameNumber().equals("321");
    }

    @Test
    void shouldDeleteAddress() {

        long idOfAddressToDelete = 5L;

        when(addressRepository.existsById(idOfAddressToDelete)).thenReturn(true);

        addressService.deleteAddress(idOfAddressToDelete);

        verify(addressRepository).deleteById(idOfAddressToDelete);
    }

}
