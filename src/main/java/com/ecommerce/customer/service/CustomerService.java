
package com.ecommerce.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.customer.entity.Customer;
import com.ecommerce.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Customer not found with id: " + id));
    }

    public Customer updateCustomer(Long id, Customer details) {
        Customer customer = getCustomerById(id);

        customer.setFirstName(details.getFirstName());
        customer.setLastName(details.getLastName());
        customer.setEmail(details.getEmail());
        customer.setPhone(details.getPhone());
        customer.setAddress(details.getAddress());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
