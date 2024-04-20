package com.manik.recipeee.services;

import java.util.List;
import com.manik.recipeee.entities.Recipe;
import com.manik.recipeee.entities.User;

public interface RecipeService {

    public Recipe createRecipe(Recipe recipe, User user);

    public Recipe findRecipeById(Long id) throws Exception;

    public void deleteRecipe(Long id) throws Exception;

    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception;

    public List<Recipe> findAllRecipes();

}
