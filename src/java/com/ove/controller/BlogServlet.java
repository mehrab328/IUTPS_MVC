/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ove.controller;

import com.ove.dao.BlogsDao;
import com.ove.model.Blogs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muhaimenul Islam
 */
public class BlogServlet extends HttpServlet {

    
    
    private BlogsDao bao;
    
    public BlogServlet() {
        super();
        bao = new BlogsDao();
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward="";
        String action = request.getParameter("action");
      
        if (action.equalsIgnoreCase("listBlog")){
            forward = "/blog.jsp";
            request.setAttribute("blogs", bao.getAllBlogs());  
        }else if (action.equalsIgnoreCase("writeb")){
            //This is for test porpuse
            forward="/write_blog.jsp";
        }
        else{
            forward = "/index.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Blogs blog = new Blogs();
       
       String uId = request.getParameter("b_name");
       System.out.println("Hello"+uId);
       blog.setuId(uId);
       blog.setTitle(request.getParameter("b_title"));
       blog.setBody(request.getParameter("b_body"));
       
       bao.addBlog(blog);
       RequestDispatcher view = request.getRequestDispatcher("/add_blog.jsp");
       view.forward(request, response);
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
