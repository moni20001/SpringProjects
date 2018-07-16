package com.homework.resident.services;

import com.homework.resident.entities.Capital;

import java.util.LinkedList;
import java.util.List;

public interface CapitalService {
    public LinkedList<Capital> findAllCapitals();
    Capital getByName(final String name);
}
