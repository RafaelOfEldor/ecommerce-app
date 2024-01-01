package com.example.factory.address;

import com.example.factory.model.Address;
import com.example.factory.service.AddressService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressServiceIntegrationTest {

    @Autowired
    AddressService addressService;

    @Test
    @Transactional
    void canFetchAllAddresses(){

        var addresses = addressService.getAddresses();

        assert addresses.size() == 50;
    }

    @Test
    @Transactional
    void canFetchPageOfTenAddresses(){

        var addresses = addressService.getAddressesPageable(1);

        assert addresses.size() == 10;
    }


    @Test
    @Transactional
    void canAddAddress(){

        assert addressService.getAddresses().size() == 50;

        Address address = new Address("MyStreet", "123");
        addressService.addAddress(address);

        assert addressService.getAddresses().size() == 51;

    }


    @Test
    @Transactional
    void canFetchAddressById(){
        Address address = new Address("MyStreet", "123");
        addressService.addAddress(address);

        assert addressService.getAddressById(address.getAddressId()) != null;
        assert addressService.getAddressById(address.getAddressId()).getAddressStreetName().equals("MyStreet");
        assert addressService.getAddressById(address.getAddressId()).getAddressStreetNameNumber().equals("123");
    }

    @Test
    @Transactional
    void canDeleteAddress(){
        Address address = new Address("MyStreetAgain", "1234");
        addressService.addAddress(address);

        assert addressService.getAddressById(address.getAddressId()) != null;
        assert addressService.getAddresses().size() == 51;

        addressService.deleteAddress(address.getAddressId());

        assert addressService.getAddressById(address.getAddressId()) == null;
        assert addressService.getAddresses().size() == 50;
    }

    @Test
    @Transactional
    void canUpdateAddress(){
        Address address = new Address("MyStreet", "123");
        addressService.addAddress(address);

        assert addressService.getAddressById(address.getAddressId()) != null;
        assert addressService.getAddressById(address.getAddressId()).getAddressStreetName() == "MyStreet";
        assert addressService.getAddressById(address.getAddressId()).getAddressStreetNameNumber() == "123";

        Address updatedAddress = new Address("YourStreet", "321");
        addressService.updateAddress(address.getAddressId(), updatedAddress);

            assert addressService.getAddressById(address.getAddressId()).getAddressStreetName() == "YourStreet";
            assert addressService.getAddressById(address.getAddressId()).getAddressStreetNameNumber() == "321";
    }

}
