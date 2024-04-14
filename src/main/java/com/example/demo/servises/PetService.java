package com.example.demo.servises;

import com.example.demo.models.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private final List<Pet> petList = new ArrayList<>();

    public void addPet(Pet pet){
        petList.add(pet);
    }

    public List<Pet> findAll(){
        petList.add(new Pet("dog", "Jack", "White"));
        return petList;
    }
}
