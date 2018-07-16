package com.homework.resident.controllers;

import org.springframework.web.servlet.ModelAndView;


public abstract class BaseController {
    public ModelAndView view(String viewName,ModelAndView modelAndView){
        modelAndView.setViewName("layout");
        modelAndView.addObject("viewName",viewName);
        return modelAndView;
    }

    public ModelAndView redirect(String url){
        return new ModelAndView("redirect:/"+url);
    }

}
