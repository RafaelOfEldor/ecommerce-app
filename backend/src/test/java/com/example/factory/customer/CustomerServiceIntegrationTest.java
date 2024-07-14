package com.example.factory.customer;

import com.example.factory.model.Customer;
import com.example.factory.service.CustomerService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceIntegrationTest {

    @Autowired
    CustomerService customerService;

    @Test
    @Transactional
    void canFetchAllCustomers(){

        var customers = customerService.getCustomers();

        assert customers.size() == 50;
    }

    @Test
    @Transactional
    void canFetchPageOfTenCustomers(){

        var customers = customerService.getCustomersPageable(1);

        assert customers.size() == 10;
    }


    @Test
    @Transactional
    void canAddCustomer(){
        assert customerService.getCustomers().size() == 50;

        Customer customer = new Customer("Jason Derulo", "jason@derluo.com");
        customerService.addCustomer(customer);

        assert customerService.getCustomers().size() == 51;

    }


    @Test
    @Transactional
    void canFetchCustomerById(){
        Customer customer = new Customer("Jason Derulo", "jason@derluo.com");
        customerService.addCustomer(customer);

        assert customerService.getCustomerById(customer.getCustomerId()) != null;
        assert customerService.getCustomerById(customer.getCustomerId()).getCustomerName().equals("Jason Derulo");
        assert customerService.getCustomerById(customer.getCustomerId()).getCustomerEmail().equals("jason@derluo.com");
    }

    @Test
    @Transactional
    void canDeleteCustomer(){
        Customer customer = new Customer("Jason Derulo", "jason@derluo.com");
        customerService.addCustomer(customer);

        assert customerService.getCustomerById(customer.getCustomerId()) != null;
        assert customerService.getCustomers().size() == 51;

        customerService.deleteCustomer(customer.getCustomerId());

        assert customerService.getCustomerById(customer.getCustomerId()) == null;
        assert customerService.getCustomers().size() == 50;
    }

    @Test
    @Transactional
    void canUpdateCustomer(){
        Customer customer = new Customer("Jason Derulo", "jason@derluo.com");
        customerService.addCustomer(customer);

        assert customerService.getCustomerById(customer.getCustomerId()) != null;
        assert customerService.getCustomerById(customer.getCustomerId()).getCustomerName() == "Jason Derulo";
        assert customerService.getCustomerById(customer.getCustomerId()).getCustomerEmail() == "jason@derluo.com";

        Customer updatedCustomer = new Customer("Mac Miller", "Mac@Miller.com");
        customerService.updateCustomer(customer.getCustomerId(), updatedCustomer);

        assert customerService.getCustomerById(customer.getCustomerId()).getCustomerName() == "Mac Miller";
        assert customerService.getCustomerById(customer.getCustomerId()).getCustomerEmail() == "Mac@Miller.com";
    }

}
