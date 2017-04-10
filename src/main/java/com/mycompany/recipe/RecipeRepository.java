package com.mycompany.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */
public interface RecipeRepository extends JpaRepository<Recipe,Long>{
    Recipe findByRecipeCode(String recipeCode);
}
