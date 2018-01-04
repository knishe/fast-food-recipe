package com.mycompany.recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 * Stores recipes
 */
@Entity
public class Recipe implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String recipeCode;
    private String description;

    public Recipe() {
    }

    public Recipe(String recipeCode, String description) {
        this.recipeCode = recipeCode;
        this.description = description;
    }

    public Recipe(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeCode='" + recipeCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
