/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryanz
 */
public class Items implements Serializable {
    private int itemID;
    private String name;
    private double totalPrice;
    private List<Ingredient> ing = new ArrayList<>();
    
    public Items(){
        this.itemID=0;
    }

    public Items(String Name) {
        this.itemID = 0;
        this.name = Name;
    }
    public void setTotalPrice(double TotalPrice){
        this.totalPrice = TotalPrice;
    }
    
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int ItemID) {
        this.itemID = ItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public double getTotalPrice() {
        this.totalPrice = 0;
        if (this.ing == null){
            return totalPrice;
        }else{
        for(Ingredient i : this.ing){
            totalPrice += i.getPrice();
        }
       
        return totalPrice;
        }
        
    }

    public List<Ingredient> getIng() {
        return ing;
    }

    public void setIng(Ingredient ing) {
        this.ing.add(ing);
    }
    
    public String ingString(){
        if(this.ing == null){
            return "";
        }else{
        
        String ingString = "It Has " + this.ing.get(0).getName();
        Ingredient temp = this.ing.get(0); //Save it
        this.ing.remove(0); //Temporarly remove first ingredient from list
        
        for(Ingredient ing : this.ing){
            ingString +=  " & " + ing.getName() ;
            }
        
        this.ing.add(0, temp); //added it right back & same index
        return ingString;
        } 
    }
        public void ClearIng(){
            this.ing.clear();
    }
}
