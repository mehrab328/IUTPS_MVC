/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ove.dao;
 
import java.sql.*;
import java.util.*;
import com.ove.model.User;
import com.ove.model.Admin;
import com.ove.util.DBConnection;
/**
 *
 * @author Muhaimenul Islam
 */
public class DataAccess {
    
    
    private Connection connection;
    public DataAccess() {
        
        connection = DBConnection.getConnection();
    }
    //CHECH USER ID
    public void checkUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("select USER_ID from users where USER_ID = ?");
            ps.setString(1, user.getUSER_ID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateUser(user);
            } else {
                addUser(user);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    //ADD USER
    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users"
                    + "(USER_ID, NAME, DEPT, BATCH, PHONE, EMAIL, DESIGNATION, PASSWORD, ADDRESS, CURRENT_JOB)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, user.getUSER_ID());
            preparedStatement.setString(2, user.getNAME());
            preparedStatement.setString(3, user.getDEPT());  
            preparedStatement.setString(4, user.getBATCH());
            preparedStatement.setString(5, user.getPHONE());
            preparedStatement.setString(6, user.getEMAIL()); 
            preparedStatement.setString(7, user.getDESIGNATION());
            preparedStatement.setString(8, user.getPASSWORD());
            preparedStatement.setString(9, user.getADDRESS()); 
            preparedStatement.setString(10, user.getCURRENT_JOB()); 
//preparedStatement.setDate(4, new java.sql.Date(user.getRegisteredon().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
}
    
    //READ ALL USER
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
               
                User user = new User(rs.getString("USER_ID"), rs.getString("NAME"),rs.getString("DEPT")
                                ,rs.getString("BATCH"), rs.getString("PHONE"), rs.getString("EMAIL"),
                                rs.getString("DESIGNATION"), rs.getString("PASSWORD"), rs.getString("ADDRESS")
                                , rs.getString("CURRENT_JOB"));
                //user.setUname(rs.getString("uname"));
                //user.setPassword(rs.getString("password"));
                //user.setEmail(rs.getString("email"));
                //user.setRegisteredon(rs.getDate("registeredon"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return users;
    }
    
    
    //update user
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set NAME=?, DEPT=?, BATCH=?,"
                                                                                +" PHONE=?, EMAIL=?, DESIGNATION=?, PASSWORD=?,"
                                                                                +" ADDRESS=?, CURRENT_JOB=?"
                                                                                +" where USER_ID=?");
            // Parameters start with 1
            //System.out.println(new java.sql.Date(user.getRegisteredon().getTime()));
            
            preparedStatement.setString(1, user.getNAME());
            preparedStatement.setString(2, user.getDEPT());  
            preparedStatement.setString(3, user.getBATCH());
            preparedStatement.setString(4, user.getPHONE());
            preparedStatement.setString(5, user.getEMAIL()); 
            preparedStatement.setString(6, user.getDESIGNATION());
            preparedStatement.setString(7, user.getPASSWORD());
            preparedStatement.setString(8, user.getADDRESS()); 
            preparedStatement.setString(9, user.getCURRENT_JOB()); 
            
            preparedStatement.setString(10, user.getUSER_ID());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //delete user
    public void deleteUser(String userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where USER_ID=?");
            // Parameters start with 1
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //get speicific user
    public User getUserById(String userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where USER_ID=?");
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                
                user.setUSER_ID(rs.getString("USER_ID"));
                user.setNAME(rs.getString("NAME"));
                user.setDEPT(rs.getString("DEPT"));
                user.setBATCH(rs.getString("BATCH"));
                user.setPHONE(rs.getString("PHONE"));
                user.setEMAIL(rs.getString("EMAIL"));
                user.setDESIGNATION(rs.getString("DESIGNATION"));
                user.setPASSWORD(rs.getString("PASSWORD"));
                user.setADDRESS(rs.getString("ADDRESS"));
                user.setCURRENT_JOB(rs.getString("CURRENT_JOB"));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return user;
    }
    
    public User loginUser(User user) {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from users "
                    + "where USER_ID = ? and PASSWORD = ?");
            ps.setString(1, user.getUSER_ID());
            ps.setString(2, user.getPASSWORD());
            ResultSet rs = ps.executeQuery();
            boolean more = rs.next();
            if(more)
            {
                String ui = rs.getString("USER_ID");
                String un = rs.getString("NAME");
                String ud = rs.getString("DEPT");
                String ub = rs.getString("BATCH");
                String up = rs.getString("PHONE");
                String ue = rs.getString("EMAIL");
                String uds = rs.getString("DESIGNATION");
                String ua = rs.getString("ADDRESS");
                String uc = rs.getString("CURRENT_JOB");
                
                user.setUSER_ID(ui);
                user.setNAME(un);
                user.setDEPT(ud);
                user.setBATCH(ub);
                user.setPHONE(up);
                user.setEMAIL(ue);
                user.setDESIGNATION(uds);
                user.setADDRESS(ua);
                user.setCURRENT_JOB(uc);
                
                user.setCheck(true);
            }else {
               
                user.setCheck(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return user;
}
    
    
    public Admin loginAdmin(Admin admin) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from admin "
                    + "where ADMIN_ID = ? and ADMIN_PASS = ?");
            ps.setString(1, admin.getADMIN_ID());
            ps.setString(2, admin.getADMIN_PASS());
            ResultSet rs = ps.executeQuery();
            boolean more = rs.next();
            
            if(more)
            {
                String ai = rs.getString("ADMIN_ID");
                admin.setADMIN_ID(ai);
                admin.setValid(true);
            }else {
                admin.setValid(false);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return admin;
}
    
   
    
}
