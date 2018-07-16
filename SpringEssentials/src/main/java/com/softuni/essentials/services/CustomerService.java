package com.softuni.essentials.services;

import com.softuni.essentials.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {


    List<Customer> findAll();

    List<Customer> extractBirthAsc();

    List<Customer> extractBirthDesc();
}
