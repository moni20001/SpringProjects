package com.homework.resident.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "viruses")
public class Virus {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name="name",nullable = false)
    @Size(min=3,max=10)
    private String name;

    @Column(name = "description",nullable = false)
    @Size(min=5,max=100)
    private String description;

    @Size(max=50)
    private String sideEffects;

    @Column(nullable = false)
    @Size(max=5)
    private String creator;

    @Column(nullable = false)
    private Boolean isDeadly;

    @Column(nullable = false)
    private Boolean isCurable;

    @Column(nullable = false)
    @Size(max=13)
    private String mutation;

    @Column(nullable = false)
    @Min(0)
    @Max(100)
    private Integer turnoverRate;

    @Column(nullable = false)
    @Min(1)
    @Max(12)
    private Integer hoursUntilMutation;

    @Size(min=2,max=7)
    private String magnitude;

    @Column(nullable = false)
    private LocalDate releasedOn;

    @ManyToMany
    @JoinTable(
            name = "viruses_capitals",
            joinColumns = {@JoinColumn(name = "virus_id")},
            inverseJoinColumns = {@JoinColumn(name = "capital_id")})
    private Set<Capital> capitals = new HashSet<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getReleasedOn() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return formatter.format(this.releasedOn);
    }
    public LocalDate getDate(){
        return this.releasedOn;
    }

    public String getReleasedOnOther() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        return formatter.format(this.releasedOn);
    }

    public void setCapitals(Set<Capital> capitals) {
        this.capitals = capitals;
    }

    public Virus() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getisDeadly() {
        return this.isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getisCurable() {
        return this.isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    public String getMutation() {
        return this.mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilMutation() {
        return hoursUntilMutation;
    }

    public void setHoursUntilMutation(Integer hoursUntilMutation) {
        this.hoursUntilMutation = hoursUntilMutation;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    public Set<Capital> getCapitals() {
        return capitals;
    }

}
