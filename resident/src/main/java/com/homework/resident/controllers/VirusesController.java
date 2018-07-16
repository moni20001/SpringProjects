package com.homework.resident.controllers;

import com.homework.resident.entities.Capital;
import com.homework.resident.entities.Virus;
import com.homework.resident.models.binding.AddVirusBindingModel;
import com.homework.resident.services.CapitalService;
import com.homework.resident.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class VirusesController extends BaseController {

    @Autowired
    private CapitalService capitalService;
    @Autowired
    private VirusService virusService;

    @GetMapping("/viruses/add")
    public ModelAndView addVirusGet(ModelAndView modelAndView){
        LinkedList<Capital> capitalsTemp = capitalService.findAllCapitals();

        modelAndView.addObject("capitals",capitalsTemp);
        modelAndView.addObject("AddVirusBindingModel",new AddVirusBindingModel());
        List<String> virusesTypes = new LinkedList<>();
        //TODO extract them to enum or something
        virusesTypes.add("ZOMBIE");
        virusesTypes.add("T_078_TYRANT");
        virusesTypes.add("GIANT_SPIDER");
        modelAndView.addObject("types",virusesTypes);
        return this.view("addVirus",modelAndView);
    }

    @PostMapping("/viruses/add")
    public ModelAndView addVirusPost(@Valid AddVirusBindingModel addVirusBindingModel, BindingResult bindingResult, Model model){

        this.virusService.create(addVirusBindingModel);
        return this.redirect("viruses/show");

    }

    @GetMapping("/viruses/edit/{id}")
    public ModelAndView editVirus(@PathVariable("id") String id, ModelAndView modelAndView){
        modelAndView.addObject("AddVirusBindingModel",new AddVirusBindingModel());
        Virus temp =(Virus) virusService.getByName(id).get();
        modelAndView.addObject("virus",temp);
        LinkedList<Capital> capitalsTemp = capitalService.findAllCapitals();

        modelAndView.addObject("capitals",capitalsTemp);
        List<String> virusesTypes = new LinkedList<>();
        //TODO extract them to enum or something
        virusesTypes.add("ZOMBIE");
        virusesTypes.add("T_078_TYRANT");
        virusesTypes.add("GIANT_SPIDER");
        modelAndView.addObject("types",virusesTypes);
        return this.view("editVirus",modelAndView);

    }
    @PostMapping("/viruses/edit/{id}")
    public ModelAndView editVirusPost(@PathVariable("id") String id, @Valid AddVirusBindingModel addVirusBindingModel, BindingResult bindingResult, Model model){


        this.virusService.edit(addVirusBindingModel,id);
        return this.redirect("viruses/show");

    }

    //TODO FORM VALIDATION

    @GetMapping("/viruses/delete/{id}")
    public ModelAndView deleteVirus(@PathVariable("id") String id, ModelAndView modelAndView){
        Virus temp =(Virus) virusService.getByName(id).get();
        modelAndView.addObject("virus",temp);
        LinkedList<Capital> capitalsTemp = capitalService.findAllCapitals();

        modelAndView.addObject("capitals",capitalsTemp);
        List<String> virusesTypes = new LinkedList<>();
        //TODO extract them to enum or something
        virusesTypes.add("ZOMBIE");
        virusesTypes.add("T_078_TYRANT");
        virusesTypes.add("GIANT_SPIDER");
        modelAndView.addObject("types",virusesTypes);
        return this.view("deleteVirus",modelAndView);

    }
    @PostMapping("/viruses/delete/{id}")
    public ModelAndView deleteVirusSubmit(@PathVariable("id") String id, ModelAndView modelAndView){
        String debug = "";
        Virus temp =(Virus) virusService.getByName(id).get();
        this.virusService.deleteById(temp.getId());
        return this.redirect("viruses/show");

    }

    @GetMapping("/viruses/show")
        public ModelAndView showViruses(ModelAndView modelAndView){
            modelAndView.addObject("viruses",virusService.findAllViruses());

            return this.view("showVirus",modelAndView);
        }

}
