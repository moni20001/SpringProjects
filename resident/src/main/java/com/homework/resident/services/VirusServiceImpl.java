package com.homework.resident.services;

import com.homework.resident.entities.Capital;
import com.homework.resident.entities.Virus;
import com.homework.resident.models.binding.AddVirusBindingModel;
import com.homework.resident.repositories.VirusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class VirusServiceImpl implements VirusService {
    private final VirusRepository virusRepository;
    private final ModelMapper modelMapper;
    private final CapitalService capitalService;

    @Autowired
    public VirusServiceImpl(VirusRepository virusRepository, ModelMapper modelMapper, CapitalService capitalService) {
        this.virusRepository = virusRepository;
        this.modelMapper = modelMapper;
        this.capitalService = capitalService;
    }


    @Override
   public List<Virus> findAllViruses() {
       return this.virusRepository.findAllViruses().stream().collect(Collectors.toUnmodifiableList());
   }

   @Override
   public boolean create(AddVirusBindingModel addVirusBindingModel){

       Virus virus = modelMapper.map(addVirusBindingModel, Virus.class);
        if(addVirusBindingModel.getisDeadly()==null){
            virus.setDeadly(false);
        }
       if(addVirusBindingModel.getisCurable()==null){
           virus.setCurable(false);
       }
       if(addVirusBindingModel.getCapitals()!= null){
           Set<Capital> capitalList = new HashSet<>();
           for (String capital : addVirusBindingModel.getCapitals()) {
               Capital tempCap = this.capitalService.getByName(capital);
               capitalList.add(tempCap);
           }
           virus.setCapitals(capitalList);
       }

       try {
           this.virusRepository.saveAndFlush(virus);
           return true;
       } catch (Throwable e) {
           return false;
       }

   }

    @Override
    public Optional<Virus> getByName(String name) {
        return this.virusRepository.findById(name);
    }


    @Override
    public void deleteById(String id) {
        String debug= "";
        this.virusRepository.deleteById(id);
    }

    @Override
    public void edit(AddVirusBindingModel addVirusBindingModel, String id) {
        Virus virus = modelMapper.map(addVirusBindingModel, Virus.class);

        //TODO: UPDATE NOT DELETE AND CREATE
       //this.virusRepository.updateVirus(virus.getCreator(),virus.getDescription(),
       //        virus.getHoursUntilMutation(),virus.getisCurable(),virus.getisDeadly(),
       //        virus.getMagnitude(),virus.getMutation(),virus.getName(),virus.getDate(),virus.getSideEffects(),virus.getTurnoverRate(),id);

        this.deleteById(id);
        if(addVirusBindingModel.getisDeadly()==null){
            virus.setDeadly(false);
        }
        if(addVirusBindingModel.getisCurable()==null){
            virus.setCurable(false);
        }
        if(addVirusBindingModel.getCapitals()!= null){
            Set<Capital> capitalList = new HashSet<>();
            for (String capital : addVirusBindingModel.getCapitals()) {
                Capital tempCap = this.capitalService.getByName(capital);
                capitalList.add(tempCap);
            }
            virus.setCapitals(capitalList);
        }

        try {
            this.virusRepository.saveAndFlush(virus);
        } catch (Throwable e) {
        }
        this.virusRepository.flush();

    }
}
