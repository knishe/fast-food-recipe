package com.mycompany.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */

@RestController
public class RecipeRestController {
    private RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe")
    Recipe recipe(@RequestParam(value = "id",defaultValue = "101") String id) {
        return recipeService.getRecipe(Integer.valueOf(id));
    }
}
