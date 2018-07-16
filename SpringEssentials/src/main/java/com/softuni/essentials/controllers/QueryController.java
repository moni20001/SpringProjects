package com.softuni.essentials.controllers;

import com.softuni.essentials.entities.Customer;
import com.softuni.essentials.repositories.CustomerRepository;
import com.softuni.essentials.services.CustomerService;
import com.softuni.essentials.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class QueryController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/all/ascending")
    public ModelAndView extractCustomersAsc(){
        ModelAndView model = new ModelAndView();
       model.addObject("customers",customerService.extractBirthAsc());
        model.setViewName("cusomers_by_birth");
        return model;
    }
    @GetMapping("/customers/all/descending")
    public ModelAndView extractCustomersDesc(){
        ModelAndView model = new ModelAndView();
        model.addObject("customers",customerService.extractBirthDesc());
        model.setViewName("cusomers_by_birth");
        return model;
    }
}
