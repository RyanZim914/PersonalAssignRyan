/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Ingredient;
import business.Items;
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
public class ItemDB {

    private static final Logger LOG = Logger.getLogger(UserDB.class.getName());

    public static int insertIntoItem(String name) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO item (name) "
                + "VALUES ( ? )";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
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

    public static int getItemID(String name) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT * FROM item "
                + "WHERE name = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            int temp = 0;
            while (rs.next()) {
                temp = rs.getInt("itemID");
            }
            //cant have the same integer and it makes a new item each time
            //get the ingredients in the item

            return temp;
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

    public static int insertIntoItemIngred(int itemID, int ingID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO itemIngred (itemID, ingredientID) "
                + "VALUES ( ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, itemID);
            ps.setInt(2, ingID);
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

    public static LinkedHashMap<Integer, Items> selectAllItems() throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        LinkedHashMap<Integer, Items> itemList = new LinkedHashMap<>();

        //SELECT * FROM `item` as `i` INNER JOIN  `itemingred` as `ig` ON `i`.`itemID` = `ig`.`itemID` INNER JOIN ingredient as `ing` ON `ig`.`ingredientID` = `ing`.`ingredientID` WHERE `i`.`itemID` = 1
        String query = "SELECT * FROM item as i "
                + "INNER JOIN  itemingred as ig ON i.itemID = ig.itemID "
                + "INNER JOIN ingredient as ing ON ig.ingredientID = ing.ingredientID";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            Ingredient ing = null;
            Items item = new Items();

            while (rs.next()) {
                if (itemList.isEmpty() || !itemList.containsKey(rs.getInt("itemID"))) {
                    item = new Items();
                    item.setItemID(rs.getInt("itemID"));
                    item.setName(rs.getString("i.name"));
                } else {
                    item = itemList.get(item.getItemID());
                }

                //get the ingredient
                ing = new Ingredient();
                ing.setIngredientId(rs.getInt("ing.ingredientID"));
                ing.setName(rs.getString("ing.name"));
                ing.setPrice(rs.getDouble("ing.price"));
                item.setIng(ing);

                itemList.put(item.getItemID(), item);
            }
            //cant have the same integer and it makes a new item each time
            //get the ingredients in the item

            return itemList;
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

    public static Items GetItem(int itemID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        Items item = new Items();  // Create a new instance of Items

        String query = "SELECT * FROM item as i "
                + "INNER JOIN  itemingred as ig ON i.itemID = ig.itemID "
                + "INNER JOIN ingredient as ing ON ig.ingredientID = ing.ingredientID "
                + "WHERE i.itemID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, itemID);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Set item details
                item.setItemID(rs.getInt("itemID"));
                item.setName(rs.getString("i.name"));

                // Create a new ingredient
                Ingredient ing = new Ingredient();
                ing.setIngredientId(rs.getInt("ing.ingredientID"));
                ing.setName(rs.getString("ing.name"));
                ing.setPrice(rs.getDouble("ing.price"));

                // Add the ingredient to the item
                item.setIng(ing);
            }

            return item;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get item sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get item null pointer??", e);
                throw e;
            }
        }
    }

    public static void DeleteItem(int itemID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE i, ig "
                + "FROM item i "
                + "INNER JOIN itemingred ig ON i.itemID = ig.itemID "
                + "WHERE i.itemID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, itemID);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** delete item sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** delete item null pointer??", e);
                throw e;
            }
        }
    }
}

//public void getIngInItems(int itemID){}
//public void getAllItems
//public void getCurrItem(int ItemID)
