package com.softuni.essentials.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    private Long id;

    private String name;

    private boolean is_importer;

    private Set<Part> parts = new HashSet<>();

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

    public boolean isIs_importer() {
        return is_importer;
    }

    public void setIs_importer(boolean is_importer) {
        this.is_importer = is_importer;
    }

    @OneToMany(mappedBy = "supplier")
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
