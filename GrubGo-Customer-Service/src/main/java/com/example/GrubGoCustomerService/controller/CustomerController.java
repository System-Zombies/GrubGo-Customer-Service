package com.example.GrubGoCustomerService.controller;

import com.example.GrubGoCustomerService.model.Customer;
import com.example.GrubGoCustomerService.model.CustomerUpdateReq;
import com.example.GrubGoCustomerService.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping("/retrieve")
    public List<Customer> fetchAllCustomer() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestParam String id, @RequestBody CustomerUpdateReq req) {
        customerService.updateCustomer(id, req);
    }


    @DeleteMapping("delete/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }

}
