package com.softuni.essentials.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cars")
public class Car {
    private Long id;

    private String make;

    private String model;

    private Long travelled_distance;

    private Set<Sale> sales = new HashSet<>();


    private Set<Part> parts = new HashSet<>();

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "car", cascade=CascadeType.ALL )
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    @ManyToMany
    @JoinTable(name="parts_cars",
            joinColumns = {@JoinColumn(name = "part_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")})
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelled_distance() {
        return travelled_distance;
    }

    public void setTravelled_distance(Long travelled_distance) {
        this.travelled_distance = travelled_distance;
    }
}
