package com.mycompany.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */
@SpringBootApplication
@EnableCaching
public class FastFoodRecipeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastFoodRecipeApplication.class,args);
    }
}
