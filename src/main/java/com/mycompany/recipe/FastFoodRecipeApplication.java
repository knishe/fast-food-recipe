package com.mycompany.recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */
@SpringBootApplication
@EnableCaching
public class FastFoodRecipeApplication {

    @Bean
    CommandLineRunner runner(RecipeRepository recipeRepository){
        return args -> {
            recipeRepository.save(new Recipe("100","Chicken"));
            recipeRepository.save(new Recipe("101","Burger"));
            recipeRepository.save(new Recipe("102","Sandwich"));

            recipeRepository.findAll().forEach(System.out::println);

            System.out.println(recipeRepository.findByRecipeCode("100"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(FastFoodRecipeApplication.class,args);
    }
}
