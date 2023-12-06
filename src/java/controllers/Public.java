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
import data.IngredientDB;
import data.ItemDB;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ryanz
 */
@WebServlet(name = "Public", urlPatterns = {"/Public"})
public class Public extends HttpServlet {

    Items newItem = new Items();

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

        String errorMessage = "";
        String url = "";
        String action = request.getParameter("action");

        if (action == null) {
            action = "index";
        }

        switch (action) {
            case "index": {
                url = "/index.jsp";
                break;
            }
            case "getList": {
                try {
                    LinkedHashMap<Integer, Items> availableItems = ItemDB.selectAllItems();
                    request.setAttribute("list", availableItems);
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }
                url = "/ListItems.jsp";
                break;
            }

            case "registerForm": {
                url = "/Register.jsp";
                break;
            }

            case "register": {
                String username = request.getParameter("username");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                // Validate input
                if (username == null || username.isEmpty()
                        || firstname == null || firstname.isEmpty()
                        || lastname == null || lastname.isEmpty()
                        || email == null || email.isEmpty()
                        || password == null || password.isEmpty()) {

                    request.setAttribute("username", username);
                    request.setAttribute("firstname", firstname);
                    request.setAttribute("lastname", lastname);
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);

                    errorMessage += "Invalid input. Please fill in all fields.";
                    url = "/Register.jsp";
                } else {
                    try {
                        User newUser = new User(username, firstname, lastname, email, password);
                        UserDB.insertIntoUser(newUser);
                        url = "/index.jsp";
                    } catch (SQLException ex) {
                        Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                        errorMessage += "Registration failed. Please try again.";
                        url = "/Private?action=RegisterForm";
                    }
                }
                break;
            }

case "login": {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Perform validation (you might want to do more robust validation)
    if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
        // If valid, redirect to index.jsp
        try {
            User loginedUser = UserDB.getUser(username, password);
            if (loginedUser != null){
                session.setAttribute("loginedUser", loginedUser);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage += "Failed UserDB";
            url = "/Login.jsp";
        }
        url = "/index.jsp";
    } else {
        // If invalid, redirect back to the login form
        url = "/Login.jsp";
        errorMessage = "Invalid username or password. Please try again.";
    }
    break;
}
    case "logout":{
        session.setAttribute("loginedUser", null);
        url="/Login.jsp";
        break;
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
