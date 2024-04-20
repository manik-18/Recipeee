package com.manik.recipeee.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping
    public String homeController() {
        return "Welcome to Recipeee.";
    }
}
