package com.homework.resident.services;

import com.homework.resident.entities.Virus;
import com.homework.resident.models.binding.AddVirusBindingModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VirusService {

    public List<Virus> findAllViruses();

    public boolean create(AddVirusBindingModel addVirusBindingModel);

    Optional<Virus> getByName(final String name);


    void deleteById(String id);

    void edit(AddVirusBindingModel addVirusBindingModel, String id);


}
