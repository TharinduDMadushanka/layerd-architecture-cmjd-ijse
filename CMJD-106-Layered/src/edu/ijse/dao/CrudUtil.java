/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao;

import edu.ijse.db.DBConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
/**
 *
 * @author ASUS
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection(); // Utilizes DBConnection to obtain a database connection (Connection object).
        
        // The getPreparedStatement method creates a PreparedStatement object with the provided SQL query and arguments (args).
        PreparedStatement statement = connection.prepareStatement(sql);
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i+1, args[i]);
            }
        }
        return statement;
    }
    
    /**
     * The executeUpdate method executes an SQL update statement (INSERT, UPDATE, DELETE) using a prepared statement 
     * and returns a boolean indicating success or failure (true for success, false for failure). 
     */

    public static boolean executeUpdate(String sql, Object... args) throws Exception{
        return getPreparedStatement(sql, args).executeUpdate() > 0;
    }
    
    /**
     * The executeQuery method executes an SQL query statement (SELECT) using a prepared statement and 
     * returns a ResultSet object containing the query results. 
     */
    public static ResultSet executeQuery(String sql, Object... args) throws Exception{
        return getPreparedStatement(sql, args).executeQuery();
    }
}
