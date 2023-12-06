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
public class Cart implements Serializable{
    int OrderID;
    List<Items> items = new ArrayList(); 
    double Total;
    
    
    
    public void SetItems(Items i){
        this.items.add(i);
    }
    
    public List<Items> GetItems(){
        return this.items;
    }
    
    public double GetTotal() {
        Total = 0;
        if (this.items != null) {
            for (Items item : this.items) {
                Total += item.getTotalPrice();
            }
        }
        return Total;
    }

    public void DeleteItem(int index){
        this.items.remove(index);
    }
}
