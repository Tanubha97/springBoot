package com.web.app.webapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateLogin(String userid, String password){
        return userid.equalsIgnoreCase("Tanubha")&&password.equals("pasword");
    }
}
