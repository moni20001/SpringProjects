package com.softuni.essentials.repositories;

import com.softuni.essentials.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT * FROM customers as c ORDER by c.birth_date ASC", nativeQuery = true)
    List<Customer> findAllCustomersBirthAsc();

    @Query(value = "SELECT * FROM customers as c ORDER by c.birth_date DESC", nativeQuery = true)
    List<Customer> findAllCustomersBirthDesc();
}
