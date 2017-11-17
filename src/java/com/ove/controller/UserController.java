package com.ove.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ove.dao.DataAccess;
import com.ove.model.Admin;
import com.ove.model.User;
/**
 *
 * @author Muhaimenul Islam
 */ 
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INDEX = "/index.jsp";
    private static String LIST_USER = "/member_list.jsp";
    private static String EDIT_USER = "/edit_pro.jsp";
    
    private DataAccess dao;
 
    public UserController() {
        super();
        dao = new DataAccess();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        System.out.println("Hello World!");
        String userId = request.getParameter("userId"); //here userId is the passed value of STUDENT_ID.it's need only for editing
        
        if (action.equalsIgnoreCase("memlog")){
            forward = "/mem_login.jsp";
            
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT_USER;
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
            
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
            
        }else if (action.equalsIgnoreCase("searchUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
            request.setAttribute("user1", dao.getUserById(userId));
           
        }else if (action.equalsIgnoreCase("gal")){
            //This is for test porpuse
            forward="/gallary.jsp";
        }
        else {
            forward = INDEX;
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("Update post is succsessfully called");
        
        User user = new User();
        user.setUSER_ID(request.getParameter("mem_id"));
        user.setNAME(request.getParameter("mem_name"));
        user.setDEPT(request.getParameter("mem_dept"));
        user.setBATCH(request.getParameter("mem_batch"));
        user.setPHONE(request.getParameter("mem_phone"));
        user.setEMAIL(request.getParameter("mem_email"));
        user.setDESIGNATION(request.getParameter("mem_des"));
        user.setPASSWORD(request.getParameter("mem_pass"));
        user.setADDRESS(request.getParameter("mem_adrs"));
        user.setCURRENT_JOB(request.getParameter("mem_job"));
        
        String userid = request.getParameter("mem_id");
        System.out.println("Update post is succsessfully called");
        user.setUSER_ID(userid);
        
        dao.updateUser(user);
        RequestDispatcher view = request.getRequestDispatcher("/mem_login.jsp");
        //request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
    
    
}