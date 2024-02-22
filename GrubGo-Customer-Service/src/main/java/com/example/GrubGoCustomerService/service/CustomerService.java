package com.example.GrubGoCustomerService.service;

import com.example.GrubGoCustomerService.model.Customer;
import com.example.GrubGoCustomerService.model.CustomerUpdateReq;
import com.example.GrubGoCustomerService.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public void createCustomer(Customer customer) {
        repository.findCustomerByEmail(customer.getEmail())
                .ifPresentOrElse(c -> {
                    System.out.println(customer + "Already exist");
                }, () -> {
                    System.out.println("Inserting" + customer);
                    repository.insert(customer);
                });
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void updateCustomer(String id, CustomerUpdateReq updatedCustomerReq) {
        // Find the existing customer
        Customer existingCustomer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        // Update fields of existing customer entity with fields from updatedCustomerReq
        existingCustomer.setUsername(updatedCustomerReq.getUsername());
        existingCustomer.setEmail(updatedCustomerReq.getEmail());
        existingCustomer.setName(updatedCustomerReq.getName());
        existingCustomer.setAddress(updatedCustomerReq.getAddress());
        existingCustomer.setPhone(updatedCustomerReq.getPhone());

        // Set the updated field to the current date and time
        existingCustomer.setUpdated(LocalDateTime.now());

        // Save the updated customer entity
        repository.save(existingCustomer);
    }

    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }
}
