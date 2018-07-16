package com.softuni.essentials.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
    public ModelAndView view(String viewName){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
