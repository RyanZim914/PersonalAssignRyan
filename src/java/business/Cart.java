/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ryanz
 */
public class Cart implements Serializable{
    int OrderID;
    List<Items> items; 
    double Total;
    
    
}
