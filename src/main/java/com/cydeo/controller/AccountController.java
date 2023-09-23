package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    /*
    write a method to return index.html including account  list information endpoint:index
     */
    @GetMapping(value = "/index")
    public String getIndexPage(){

        return "account/index";
    }
}
