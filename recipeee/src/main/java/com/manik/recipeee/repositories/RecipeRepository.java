package com.manik.recipeee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manik.recipeee.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
