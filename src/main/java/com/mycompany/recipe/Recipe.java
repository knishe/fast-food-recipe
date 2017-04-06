package com.mycompany.recipe;

import java.io.Serializable;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */
public class Recipe implements Serializable{
    private int id;
    private String description;

    public Recipe() {
    }

    public Recipe(String description) {
        this.description = description;
    }

    public Recipe(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
