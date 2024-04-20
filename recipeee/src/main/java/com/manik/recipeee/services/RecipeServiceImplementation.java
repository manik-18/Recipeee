package com.manik.recipeee.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manik.recipeee.entities.Recipe;
import com.manik.recipeee.entities.User;
import com.manik.recipeee.repositories.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {
        Recipe createdRecipe = new Recipe();
        createdRecipe.setName(recipe.getName());
        createdRecipe.setDescription(recipe.getDescription());
        createdRecipe.setType(recipe.getType());
        createdRecipe.setIngredients(recipe.getIngredients());
        createdRecipe.setSteps(recipe.getSteps());
        createdRecipe.setDuration(recipe.getDuration());
        createdRecipe.setImageUrl(recipe.getImageUrl());
        createdRecipe.setUser(user);
        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipeById(Long id) throws Exception {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            return optionalRecipe.get();
        }
        throw new Exception("Recipe not found with id: " + id);
    }

    @Override
    public void deleteRecipe(Long id) throws Exception {
        findRecipeById(id);
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe updatedRecipe, Long id) throws Exception {
        Recipe oldRecipe = findRecipeById(id);

        if (updatedRecipe.getName() != null) {
            oldRecipe.setName(updatedRecipe.getName());
        }
        if (updatedRecipe.getDescription() != null) {
            oldRecipe.setDescription(updatedRecipe.getDescription());
        }
        if (updatedRecipe.getType() != null) {
            oldRecipe.setType(updatedRecipe.getType());
        }
        if (updatedRecipe.getIngredients() != null) {
            oldRecipe.setIngredients(updatedRecipe.getIngredients());
        }
        if (updatedRecipe.getSteps() != null) {
            oldRecipe.setSteps(updatedRecipe.getSteps());
        }
        if (updatedRecipe.getDuration() != null) {
            oldRecipe.setDuration(updatedRecipe.getDuration());
        }
        if (updatedRecipe.getImageUrl() != null) {
            oldRecipe.setImageUrl(updatedRecipe.getImageUrl());
        }

        return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

}