package com.homework.resident.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

    @GetMapping("/")
    public ModelAndView getHomePage(ModelAndView modelAndView){
        return this.view("index",modelAndView);
    }

}
