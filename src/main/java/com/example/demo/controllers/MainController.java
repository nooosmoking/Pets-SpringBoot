package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/kitten")
    public String kitten(){

        return "kitten.html";
    }

    @RequestMapping("/dog")
    public String dog(){

        return "dog.html";
    }
}
