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

    @RequestMapping("/all_pets")
    public String viewPets(Model model){
        List<Pet> allPets = petService.findAll();
        model.addAttribute("pets", allPets);
        return "pets.html";
    }

    @RequestMapping("/")
    public String home(@RequestParam String color, Model page){
        page.addAttribute("color", color);
        page.addAttribute("urlDog", "window.location.href='http://localhost:8080/pet?petType=dog&color=" + color +"'");
        page.addAttribute("urlKitten", "window.location.href='http://localhost:8080/pet?petType=kitten&color=" + color +"'");
        return "main.html";
    }

    @RequestMapping("/pet")
    public String pet(@RequestParam String petType, @RequestParam String color, Model page){
        page.addAttribute("petType", petType);
        page.addAttribute("color", color);
        return "pet.html";
    }
}
