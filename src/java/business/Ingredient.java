/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.Serializable;

/**
 *
 * @author ryanz
 */
public class Ingredient implements Serializable{
    private int ingredientID;
    private String name;
    private double price;

    public Ingredient() {
    }

    public Ingredient(int IngredientId, String Name, double price) {
        this.ingredientID = IngredientId;
        this.name = Name;
        this.price = price;
    }

    public int getIngredientId() {
        return ingredientID;
    }

    public void setIngredientId(int IngredientId) {
        this.ingredientID = IngredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}

