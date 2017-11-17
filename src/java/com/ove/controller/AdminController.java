package com.ove.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
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
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/admin_addMem.jsp";
    private static String LIST_USER = "/member_list1.jsp";
    private static String EDIT_USER = "/edit_pro1.jsp";
    
    private DataAccess dao;
    
    public AdminController() {
        super();
        dao = new DataAccess();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        
        if (action.equalsIgnoreCase("delete")){
            String userId = request.getParameter("userId");
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit1")){
            forward = EDIT_USER;
            //String userId = request.getParameter("userId"); //here userId is the passed value of STUDENT_ID.it's need only for editing
           // User user = dao.getUserById(userId);
            //request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("addMem")){
            forward = INSERT_OR_EDIT;

        }else if (action.equalsIgnoreCase("listUser1")){
            forward = "/member_list1.jsp";
            request.setAttribute("users", dao.getAllUsers());

        }else if (action.equalsIgnoreCase("searchUser")){
            forward = LIST_USER;
            String userId = request.getParameter("userId");
            request.setAttribute("users", dao.getAllUsers());
            request.setAttribute("user1", dao.getUserById(userId));
           
        }else if (action.equalsIgnoreCase("Adminlogin")){
            forward="/admin_log.jsp";
        }
        else {
            forward = "index_1.jsp";
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
        /*try {
            Date reg = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dob"));
            System.out.println("rrrrrrrrrrr"+ reg);
            user.setRegisteredon(reg);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        String userid = request.getParameter("mem_id");
//        if(userid == null || userid.isEmpty())
//        {
//            dao.addUser(user);
//        }
//        else
//        {
            user.setUSER_ID(userid);
            dao.checkUser(user);
//        }
        RequestDispatcher view = request.getRequestDispatcher("/member_list1.jsp");
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
    
    
}