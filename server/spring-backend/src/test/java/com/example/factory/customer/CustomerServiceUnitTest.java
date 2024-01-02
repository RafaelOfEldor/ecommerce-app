package com.example.factory.customer;


import com.example.factory.model.Customer;
import com.example.factory.repository.CustomerRepository;
import com.example.factory.service.CustomerService;
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
public class CustomerServiceUnitTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;


    @Test
    void shouldFetchAllCustomers(){

        List<Customer> customerList = List.of(new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customerList);

        assert customerService.getCustomers().size() == 2;
    }

    @Test
    void shouldAddACustomer(){
        Customer customer = new Customer("Jason Derulo", "jason@derulo.com");

        when(customerRepository.save(customer)).thenReturn(customer);

        assert customerService.addCustomer(customer).getCustomerName().equals("Jason Derulo");
        assert customerService.addCustomer(customer).getCustomerEmail().equals("jason@derulo.com");
    }

    @Test
    void shouldFetchCustomerById(){
        Optional<Customer> customer = Optional.of(new Customer("Jason Derulo", "jason@derulo.com"));

        Mockito.<Optional<Customer>>when(customerRepository.findById(customer.get().getCustomerId())).thenReturn(customer);

        assert customerService.getCustomerById(customer.get().getCustomerId()).getCustomerName().equals("Jason Derulo");
        assert customerService.getCustomerById(customer.get().getCustomerId()).getCustomerEmail().equals("jason@derulo.com");
    }

    @Test
    void shouldUpdateCustomer() {
        Customer existingCustomer = new Customer("Jason Derulo", "jason@derulo.com");
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        Customer updatedCustomer = new Customer("Mac Miller", "mac@miller.com");
        Optional<Customer> optionalUpdatedCustomer = Optional.of(updatedCustomer);

        when(customerRepository.findById(5L)).thenReturn(optionalUpdatedCustomer);
        when(customerRepository.save(updatedCustomer)).thenReturn(updatedCustomer);

        assert  customerService.updateCustomer(5L, updatedCustomer).getCustomerName().equals("Mac Miller");
        assert  customerService.updateCustomer(5L, updatedCustomer).getCustomerEmail().equals("mac@miller.com");
    }

    @Test
    void shouldDeleteCustomer() {

        long idOfCustomerToDelete = 5L;

        when(customerRepository.existsById(idOfCustomerToDelete)).thenReturn(true);

        customerService.deleteCustomer(idOfCustomerToDelete);

        verify(customerRepository).deleteById(idOfCustomerToDelete);
    }
}
