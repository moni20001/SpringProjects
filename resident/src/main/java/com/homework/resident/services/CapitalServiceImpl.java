package com.homework.resident.services;

import com.homework.resident.entities.Capital;
import com.homework.resident.repositories.CapitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CapitalServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

@Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
     this.modelMapper = modelMapper;
}
@Override
    public LinkedList<Capital> findAllCapitals(){
    LinkedList<Capital> temp = new LinkedList<>();
    var all = this.capitalRepository.findAllCapitals().stream().collect(Collectors.toUnmodifiableList());
    for (Capital c : all) {
        temp.add(c);
    }
        return temp;
    }


    @Override
    public Capital getByName(final String name) {
        return  this.capitalRepository.findByName(name);
    }


}
