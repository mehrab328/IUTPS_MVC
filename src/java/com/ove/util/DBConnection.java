/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ove.util;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Muhaimenul Islam
 */
public class DBConnection {
    public static Connection getConnection() {
          try  {
              Class.forName("com.mysql.jdbc.Driver");
              String url = "jdbc:mysql://localhost:3306/iutpsdb";
              String user = "root";
              String password = "root";
              Connection con = DriverManager.getConnection(url,user,password);
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
    
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}