package com.laptrinhweb.healthcare.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
public class DBContext {
    public Connection conn=null;
    public DBContext(String URL,String userName,String password){
        try {
            //call driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //connection
            conn=DriverManager.getConnection(URL,userName, password);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public DBContext(){
        this("jdbc:sqlserver://localhost:1433;databaseName=healthcare","sa","123");
    }
    public Connection getConn() {
        return conn;
    }
    public static void main(String[] args) {
        new DBContext();
    }
}
