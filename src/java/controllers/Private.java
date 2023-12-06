/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import business.Cart;
import business.Ingredient;
import business.Items;
import business.User;
import data.IngredientDB;
import data.ItemDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ryanz
 */
@WebServlet(name = "Private", urlPatterns = {"/Private"})
public class Private extends HttpServlet {

    Items newItem = new Items();
    Cart newCart = new Cart();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        User loginedUser = (User) session.getAttribute("loginedUser");
        
        String action = request.getParameter("action");
        String errorMessage = "";
        String url = "";
            
        // Check if the user is logged in
        if (loginedUser == null) {
        // Handle the case when the user is not logged in
        errorMessage = "You are not logged in. Please log in first.";
        url = "/Login.jsp";
        }else{
        switch (action) {
            //This is for the ingredients//
            case "NewIngredientPage": {
                try {
                    request.setAttribute("ingredients", IngredientDB.selectAllIngredients());
                } catch (SQLException ex) {
                    Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
                }
                url = "/CreateIngredients.jsp";
                break;
            }
            case "RemoveIngredient": {
                int currIngID = Integer.parseInt(request.getParameter("currIngID"));
                try {
                    IngredientDB.deleteIngredient(currIngID);
                } catch (SQLException ex) {
                    Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
                }
                url = "/Private?action=NewIngredientPage";
                break;
            }

            case "addIngredient": {
                String name = request.getParameter("ingName");
                double price = Double.parseDouble(request.getParameter("ingPrice"));
                if (price >= 0) {
                    try {
                        IngredientDB.insertIntoIngredient(new Ingredient(name, price));
                    } catch (SQLException ex) {
                        Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                url = "/Private?action=NewIngredientPage";
                break;
            }
            //End for Ingredients//
            //This is for Items//

            case "CreateItemPage": {
                LinkedHashMap<Integer, Ingredient> list = new LinkedHashMap<>();
                try {
                    list = IngredientDB.selectAllIngredients();
                    request.setAttribute("ingredients", list);
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }
                url = "/CreateItem.jsp";
                
                if (newItem.getIng().size() > 0){
                request.setAttribute("itemDescription", newItem.ingString());
                }
                request.setAttribute("total", newItem.getTotalPrice());
                
                break;
            }

            case "AddIngToItem": {
                LinkedHashMap<Integer, Ingredient> list = new LinkedHashMap<>();
                // Have List
                try {
                    list = IngredientDB.selectAllIngredients();
                    request.setAttribute("ingredients", list);
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Actually add Ingredients
                int ingredID = Integer.parseInt(request.getParameter("ingID"));
                Ingredient ing;

                try {
                    ing = IngredientDB.SelectIngredient(ingredID);
                    newItem.setIng(ing); // added to the array
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("itemDescription", newItem.ingString());
                request.setAttribute("total", newItem.getTotalPrice());

                url = "/CreateItem.jsp";
                break;
            }

            case "CreateNewItem": {
                url = "/index.jsp";
                String itemName = request.getParameter("newItemName");
                newItem.setName(itemName);

                try {
                    ItemDB.insertIntoItem(itemName);
                    int itemID = ItemDB.getItemID(itemName);
                    for (Ingredient ing : newItem.getIng()) {
                        ItemDB.insertIntoItemIngred(itemID, ing.getIngredientId());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }
                newItem = new Items();
                break;
            }
            case "ResetIngredients":{
                newItem.ClearIng();
                url = "/Private?action=CreateItemPage";
                break;
            }
            //End For Create Items//
            //Delete Items//
            case "DeleteItemsPage":{
                try{
                LinkedHashMap<Integer, Items> availableItems = ItemDB.selectAllItems();
                request.setAttribute("list", availableItems);
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }
                url = "/DeletingItems.jsp";
                break;
            }
            
            case "DeleteItemFromDatabase":{ 
            try {
                int ItemID = Integer.parseInt(request.getParameter("ItemID"));
                ItemDB.DeleteItem(ItemID);
            } catch (SQLException ex) {
                Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
            }
            url="/Private?action=DeleteItemsPage";
            }
            //End FOr Delete Items//
            //Cart Items//
            
            case "CartPage":{
                request.setAttribute("cartList", newCart.GetItems());
                request.setAttribute("grandTotal", newCart.GetTotal());
                url="/Cart.jsp";
                break;
            }
            
            case "AddToCart":{              
            try {
                //Get Item
                int ItemID = Integer.parseInt(request.getParameter("ItemID"));
                Items currItem = ItemDB.GetItem(ItemID);
                
                //Add item to cart
                newCart.SetItems(currItem);
            } catch (SQLException ex) {
                Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
            }
            url="/Public?action=getList";
            break;
            }
            
            case "RemoveFromCart":{
               int ItemIndex = Integer.parseInt(request.getParameter("ItemIndex"));
               newCart.DeleteItem(ItemIndex);
               url = "/Private?action=CartPage";
            break;
            }

            
            
            case "SubmitCart":{
                newCart = new Cart();
                url="/index.jsp";
                break;
            }
            //End of cart
            
        }
    }
        request.setAttribute("errorMessage", errorMessage);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
