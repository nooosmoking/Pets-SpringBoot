package com.example.demo.controllers;

import com.example.demo.models.Pet;
import com.example.demo.servises.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping("/pets")
    public String viewPets(@RequestParam(required = false) String color, Model page){
        List<Pet> allPets = petService.findAll();
        page.addAttribute("pets", allPets);
        page.addAttribute("color", color);
        return "pets.html";
    }

    @PostMapping("/pets")
    public String addPet(@RequestParam(required = false) String color, Pet pet, Model page){
        petService.addPet(pet);
        List<Pet> allPets = petService.findAll();
        page.addAttribute("pets", allPets);
        page.addAttribute("color", color);
        return "pets.html";
    }

}
