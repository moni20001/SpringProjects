package com.homework.resident.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "capitals")
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false, insertable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @ManyToMany(mappedBy = "capitals")
    private Set<Virus> viruses = new HashSet<>();

    @Override
    public String toString() {
        return this.name;
    }

    public Capital() {
    }
}
