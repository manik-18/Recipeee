package com.manik.recipeee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manik.recipeee.entities.Recipe;
import com.manik.recipeee.entities.User;
import com.manik.recipeee.services.RecipeService;
import com.manik.recipeee.services.UserService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe, @RequestHeader("Authorization") String jwt)
            throws Exception {
        User user = userService.findUserByJwt(jwt);
        return recipeService.createRecipe(recipe, user);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe findRecipeById(@PathVariable Long id) throws Exception {
        return recipeService.findRecipeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) throws Exception {
        recipeService.deleteRecipe(id);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {
        return recipeService.updateRecipe(recipe, id);
    }
}