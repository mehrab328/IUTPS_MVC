/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.*;

import com.ove.dao.*;
import com.ove.model.*;
/**
 *
 * @author Muhaimenul Islam
 */
public class TestSQL {
    
    
    
    public static void main(String[] args) {
      // Prints "Hello, World" in the terminal window.
    
    User us = new User();
    User us2 = new User();
    DataAccess dt = new DataAccess();
      System.out.println("Hello");
    String id = "2121";

    Blogs bg = new Blogs();
    BlogsDao bt = new BlogsDao(); 
    bg.setuId("134414");
    bg.setTitle("Testing");
    bg.setBody("This is a Test purpose for adding articles in blog");
    System.out.println("Hello");
        bt.addBlog(bg);
        System.out.println("Hello After");
    //us.setUSER_ID(id);
    //us.setPASSWORD(pw);
         // System.out.println("Hello");
        // dt.updateUser(us);
        // us2 = dt.getUserById(id);
         // System.out.println("Hello " + us2.getNAME());
    
           
   }
    
}
