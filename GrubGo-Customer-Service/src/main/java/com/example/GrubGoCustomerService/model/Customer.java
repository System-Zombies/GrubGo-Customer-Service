package com.example.GrubGoCustomerService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Customer {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private String email;
    private String name;
    private Address address;
    private String phone;
    private LocalDateTime created;
    private LocalDateTime updated;
    public Customer(String username, String email, String name, Address address, String phone) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

}
