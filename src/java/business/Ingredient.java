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
    private int IngredientId;
    private String Name;
    private double price;

    public Ingredient() {
    }

    public Ingredient(int IngredientId, String Name, double price) {
        this.IngredientId = IngredientId;
        this.Name = Name;
        this.price = price;
    }

    public int getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(int IngredientId) {
        this.IngredientId = IngredientId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}

