/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ove.dao;

import com.ove.model.Blogs;
import com.ove.model.User;
import com.ove.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muhaimenul Islam
 */
public class BlogsDao {
    
    
     private Connection connection;
    public BlogsDao() {
        
        connection = DBConnection.getConnection();
    }
    
    //ADD USER
    public void addBlog(Blogs blog) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into blogs"
                    + "(U_ID, TITLE, BODY) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, blog.getuId());
            preparedStatement.setString(2, blog.getTitle()); 
            preparedStatement.setString(3, blog.getBody());
            //preparedStatement.setDate(4, new java.sql.Date(user.getRegisteredon().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
}
    
    //READ ALL USER
    public List<Blogs> getAllBlogs() {
        List<Blogs> blogs = new ArrayList<Blogs>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from blogs");
            while (rs.next()) {
                Blogs blog = new Blogs(rs.getString("B_ID"), rs.getString("U_ID"),rs.getString("TITLE"),
                        rs.getString("BODY"),rs.getString("BTIME"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }
    
    
    //update user
    public void updateB(Blogs blog) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update blogs set TITLE=?, BODY=?"
                                                                                +" where B_ID=?");
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getBody());  
            preparedStatement.setString(3, blog.getbId());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //delete user
    public void deleteBlog(String bId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from blogs where B_ID=?");
            preparedStatement.setString(1, bId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //get speicific user's blog
    public Blogs getBlogById(String userId) {
        Blogs blog = new Blogs();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where USER_ID=?");
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                blog.setbId(rs.getString("B_ID"));
                blog.setuId(rs.getString("U_ID"));
                blog.setTitle(rs.getString("TITLE"));
                blog.setBtime(rs.getString("BTIME"));
                blog.setBody(rs.getString("BODY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blog;
    }
}
