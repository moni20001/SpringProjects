package com.homework.resident.models.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class AddVirusBindingModel {

    @Length(min = 3, max = 10)
    private String name;

    @Length(min = 5, max = 100)
    private String description;

    @Length(max = 50)
    private String sideEffects;

    @Pattern(regexp = "^Corp$|^corp\\.$")
    private String creator;

    @NotNull()
    private Boolean isDeadly;

    @NotNull()
    private Boolean isCurable;

    @NotNull()
    private String mutation;

    @Min(0)
    @Max(100)
    private Integer turnoverRate;

    @NotNull()
    @Min(1)
    @Max(12)
    private Integer hoursUntilMutation;

    @NotNull()
    private String magnitude;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedOn;


    @NotEmpty()
    private List<String> capitals;

    public String getName() {
        return name;
    }

    public AddVirusBindingModel() {
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
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getisDeadly() {
        return this.isDeadly;
    }

    public void setisDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getisCurable() {
        return this.isCurable;
    }

    public void setisCurable(Boolean curable) {
        isCurable = curable;
    }

    public String getMutation() {
        return this.mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return this.turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilMutation() {
        return this.hoursUntilMutation;
    }

    public void setHoursUntilMutation(Integer hoursUntilMutation) {
        this.hoursUntilMutation = hoursUntilMutation;
    }

    public String getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getReleasedOn() {
        return this.releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    public List<String> getCapitals() {
        return this.capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }
}
