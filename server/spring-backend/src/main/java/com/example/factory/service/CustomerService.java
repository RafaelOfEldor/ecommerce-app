package com.example.factory.service;

import com.example.factory.model.Customer;
import com.example.factory.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer Customer) {
        return customerRepository.save(Customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersPageable(int pageNumber) {
        return customerRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteCustomer(Long id) { customerRepository.deleteById(id);}

    public Customer updateCustomer(Long id, Customer newCustomer) {

        return customerRepository.findById(id)
                .map(customer -> {
                    if (newCustomer.getCustomerName() != null) {
                        customer.setCustomerName(newCustomer.getCustomerName());
                    }
                    if (newCustomer.getCustomerEmail() != null) {

                        customer.setCustomerEmail(newCustomer.getCustomerEmail());
                    }
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    return customerRepository.save(newCustomer);
                });
    }

}
