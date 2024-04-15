package com.example.demo.controllers;

import com.example.demo.models.Pet;
import com.example.demo.servises.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    @RequestMapping("/pets")
    public String viewPets(@RequestParam(required = false) String color, Model page){
        List<Pet> allPets = petService.findAll();
        page.addAttribute("pets", allPets);
        page.addAttribute("color", color);
        page.addAttribute("urlDog", "window.location.href='http://localhost:8080/pet?petType=dog&color=" + color +"'");
        page.addAttribute("urlKitten", "window.location.href='http://localhost:8080/pet?petType=kitten&color=" + color +"'");
        return "pets.html";
    }

    @RequestMapping("/pet")
    public String pet(@RequestParam String petType, @RequestParam String color, Model page){
        page.addAttribute("petType", petType);
        page.addAttribute("color", color);
        return "pet.html";
    }
}
