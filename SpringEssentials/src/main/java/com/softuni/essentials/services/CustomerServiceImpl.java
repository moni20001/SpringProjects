package com.softuni.essentials.services;

import com.softuni.essentials.entities.Customer;
import com.softuni.essentials.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository customerRepository,
                               final ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Customer> findAll(){
        return this.customerRepository.findAll().stream().collect(Collectors.toUnmodifiableList()); //customerRepository.findAllByBirth_date();
    }

    @Override
    public List<Customer> extractBirthAsc() {
        return this.customerRepository.findAllCustomersBirthAsc().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Customer> extractBirthDesc() {
        return this.customerRepository.findAllCustomersBirthDesc().stream().collect(Collectors.toUnmodifiableList());
    }
}
