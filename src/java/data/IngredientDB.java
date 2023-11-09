/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryanz
 */
public class IngredientDB {
        private static final Logger LOG = Logger.getLogger(UserDB.class.getName());

    public static int insertIntoIngredient(Ingredient ing) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO ingredient (ingredientID, name, price) "
                + "VALUES ( ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ing.getIngredientId());
            ps.setString(2, ing.getName());
            ps.setDouble(3, ing.getPrice());
            return ps.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** insert user sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** insert user null pointer??", e);
                throw e;
            }
        }
    }
        public static LinkedHashMap<Integer, Ingredient> selectAllIngredients() throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedHashMap<Integer, Ingredient> ingList = new LinkedHashMap<Integer, Ingredient>();
        
        String query = "SELECT * FROM ingredient ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            Ingredient ing = null;
            while (rs.next()) {
                ing = new Ingredient();
                ing.setIngredientId(rs.getInt("ingredientID"));
                ing.setName(rs.getString("name"));
                ing.setPrice(rs.getDouble("price"));
                ingList.put(ing.getIngredientId(), ing);

            }
            return ingList;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** select all movies sql", e);
            throw e;

        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** select all movies null pointer??", e);
                throw e;
            }
        }
    }
        
public static Ingredient SelectIngredient(int ingID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //LinkedHashMap<Integer, Ingredient> ingList = new LinkedHashMap<Integer, Ingredient>();
        
        String query = "SELECT * FROM ingredient Where ingredientID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ingID);
            rs = ps.executeQuery();
                Ingredient ing = null;
            while (rs.next()) {
                ing = new Ingredient();
                ing.setIngredientId(rs.getInt("ingredientID"));
                ing.setName(rs.getString("name"));
                ing.setPrice(rs.getDouble("price"));
            }
            return ing;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** select all movies sql", e);
            throw e;

        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** select all movies null pointer??", e);
                throw e;
            }
        }
    }
}

