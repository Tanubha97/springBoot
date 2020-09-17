package com.web.app.webapp.controller;

import com.web.app.webapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    LoginService service;
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        //model.put("name", name);
        return "login";
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        if(!service.validateLogin(name, password)){
            model.put("errorMessage","Invalid userId or password");
            return "login";
        }

        else{
        model.put("name", name);
        model.put("password", password);
        return "welcome";
        }
    }
}
