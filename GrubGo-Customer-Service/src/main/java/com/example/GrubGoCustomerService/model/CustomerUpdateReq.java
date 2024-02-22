package com.example.GrubGoCustomerService.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class CustomerUpdateReq {
    private String username;
    @Indexed(unique = true)
    private String email;
    private String name;
    private Address address;
    private String phone;


    public CustomerUpdateReq(String username, String email, String name, Address address, String phone) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
