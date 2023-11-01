/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import business.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.User;
import data.UserDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import business.Items;
import java.util.LinkedHashMap;
import java.util.List;
/**
 *
 * @author ryanz
 */
@WebServlet(name = "Public", urlPatterns = {"/Public"})
public class Public extends HttpServlet {
    
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
        
        String url = "";
        
        String action = request.getParameter("action");
        
        LinkedHashMap<Integer, Items> items = new LinkedHashMap();
        
        ArrayList<Ingredient> Ing = new ArrayList<>();
        //ArrayList<Items> items = new ArrayList<>();
        Ingredient Ing1 = new Ingredient(1, "Lettuce", 12);
        Ingredient Ing2 = new Ingredient(3, "Lettuce", 12);
        Ingredient Ing3 = new Ingredient(2, "Lettuce", 12);
        
        Ing.add(Ing1);
        Ing.add(Ing2);
        Ing.add(Ing3);
               
        Items i1 = new Items(11, "Soft Taco", 30, Ing);
        Items i2 = new Items(12, "Hard Taco", 30, Ing);
        Items i3 = new Items(13, "Taco Pizza", 30, Ing);
        //int ItemID, String Name, double TotalPrice, ArrayList<Ingredient> ing
        
        items.put(i1.getItemID(), i1);
        items.put(i2.getItemID(), i2);
        items.put(i3.getItemID(), i3);
        
        if (action == null){
            action = "getList";
            request.setAttribute("list", items);
             url = "/ListItems.jsp";
        }
        
        
        
        switch(action){
            case "getList":{
                request.setAttribute("list", items);
            }
                case "register":{
                    String username = request.getParameter("username");
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    
                    if (username == null && firstname == null || lastname == null || email == null || password == null){
                        request.setAttribute("errorMessage", "something is null please do your fucking job you idiot.");
                    }else{
                    
                    try {
                        User u = new User(username,firstname,lastname,email,password);
                        UserDB.insertIntoUser(u);
                    } catch (SQLException ex) {
                        Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   }
               }
                case "login": {
                    
                }
                
                
                
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
                
           }
        
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
