package com.softuni.essentials.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private boolean isYoungDriver;

    private Set<Sale> sales;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return this.birthDate;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birthDate = birth_date;
    }

    public boolean isIs_young_driver() {
        return this.isYoungDriver;
    }

    public void setIs_young_driver(boolean is_young_driver) {
        this.isYoungDriver = is_young_driver;
    }


    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
