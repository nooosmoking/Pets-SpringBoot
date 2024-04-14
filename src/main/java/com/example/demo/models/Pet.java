package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pet {
    private String petType;
    private String name;
    private String color;
}

