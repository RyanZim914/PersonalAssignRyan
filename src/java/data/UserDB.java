/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryanz
 */
public class UserDB {
    private static final Logger LOG = Logger.getLogger(UserDB.class.getName());

    public static int insertIntoUser(User user) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO user (userID,firstName, lastName, userName, email, password) "
                + "VALUES ( ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
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
    public static User getUser(String username, String password) throws SQLException {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String query = "SELECT * FROM user WHERE userName = ? AND password = ?";
    try {
        ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();

        if (rs.next()) {
            // User found, create and return the User object
            User user = new User();
            user.setUserID(rs.getInt("userID"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setUserName(rs.getString("userName"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        } else {
            // No user found with the given credentials
            return null;
        }
    } catch (SQLException e) {
        LOG.log(Level.SEVERE, "*** select user by username and password sql", e);
        throw e;
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            pool.freeConnection(connection);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "*** select user by username and password null pointer??", e);
            throw e;
        }
    }
}
    
}
