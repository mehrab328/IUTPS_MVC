<%-- 
    Document   : index
    Created on : Sep 11, 2016, 9:46:30 PM
    Author     : Muhaimenul Islam
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.ove.model.User" %>
<%@page import="com.ove.dao.DataAccess" %>
<%@page import= "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Member's Profile</title>

        <link rel="stylesheet" type="text/css" href="css/i_style.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/image_slide.js"></script>

    </head>

    <body>
        <div id="main">
            <div id="header">
                <div id="banner" style="display: inline">
                    <div id="welcome">
                        <br>
                        <img width="100" height="90" src="images/black-02.png" alt="iutps logo" style="float: left"/>
                        <h1>IUT Photography Society</h1>
                        <h2>Photography came in my life (Slogan)</h2>
                    </div><!--close welcome-->
                    <!--<div id="welcome_slogan">
                      <h1>Photography came in my life (Slogan)</h1>
                    </div><!--close welcome_slogan-->
                </div><!--close banner-->
            </div><!--close header-->

            <div id="menubar">
                <nav class="menu">
                    <ul class="clearfix">
                        <li><a href="UserController?action=index">Home</a></li>
                        <li class="current-item"><a href="mem_welcome.jsp">Your Profile</a></li>
                        <!--<li><a href="mem_login.php">Member's Login</a></li>-->
                        <li><a href="#">Information<span class="arrow">&#9660;</span></a>
                            <ul class="sub-menu">
                                <li><a href="history.jsp">History</a></li>
                                <li><a href="services.jsp">Services</a></li>
                                <li><a href="UserController?action=listuser">Members</a></li>
                                <li><a href="faq.jsp">FAQ</a></li>
                                <li><a href="join.jsp">Join Us</a></li>
                            </ul>
                        </li>
                        <li><a href="UserController?action=gal">Gallery</a></li>
                        <li><a href="BlogServlet?action=listBlog">Blog</a></li>
                        <!--<li class="current-item"><a href="mem_welcome.php">Profile</a></li>-->
                        <li><a href="contact.jsp">Contact Us</a></li>
                    </ul>
                </nav>
            </div><!--close menubar-->

            <div id="site_content">		

                <div class="sidebar_container">       
                    <div class="sidebar">
                        <div class="sidebar_item">
                            <h2>Latest Update</h2>
                            <h3>25th March 2016</h3>
                            <p>Meeting will be held at 4.00PM. Everyone should come at room 405.</p>
                        </div><!--close sidebar_item--> 
                    </div><!--close sidebar-->     		
                    <div class="sidebar">
                        <div class="sidebar_item">
                            <h2>Upcoming Events</h2>
                            <h3>January 2016</h3>
                            <p>PS Freshers. First year students should be introduced with us.</p>         
                        </div><!--close sidebar_item--> 
                    </div><!--close sidebar-->
                    <div class="sidebar">
                        <div class="sidebar_item">
                            <h3>May 2016</h3>
                            <p>Exhibition. Some good photos of PS member's will be displayed in Student Center </p>         
                        </div><!--close sidebar_item--> 
                    </div><!--close sidebar-->  
                    <div class="sidebar">
                        <div class="sidebar_item">
                            <h3>November 2016</h3>
                            <p>Break The Circle, Inter Photography Competition of different universities.</p>         
                        </div><!--close sidebar_item--> 
                    </div><!--close sidebar-->  		
                </div><!--close sidebar_container-->	

                <div class="slideshow">
                    <ul class="slideshow">
                        <li class="show"><img width="680" height="250" src="images/001.jpg" alt="&quot;Preparation of 2nd Intra IUT Photography Exhibition of 2015&quot;" /></li>
                        <li><img width="680" height="250" src="images/002.jpg" alt="&quot;IUT&quot;" /></li>
                    </ul>
                </div>   

                <div id="content">
                    <div class="content_item">

                        <% User currentUser = (User) (session.getAttribute("currentSessionUser"));
                            DataAccess dt = new DataAccess();
                            String id = currentUser.getUSER_ID();
                            currentUser = dt.getUserById(id);%>


                        <h2>Welcome <%= currentUser.getNAME()%>  ! </h2><br/>

                        <p>Student ID : <%= currentUser.getUSER_ID()%> <br />
                        <p>Name : <%= currentUser.getNAME()%> <br />
                        <p>Department : <%= currentUser.getDEPT()%> <br />
                        <p>Batch : <%= currentUser.getBATCH()%> <br />
                        <p>Phone Number : <%= currentUser.getPHONE()%> <br />
                        <p>E-mail : <%= currentUser.getEMAIL()%> <br />
                        <p>Designation : <%= currentUser.getDESIGNATION()%> <br />
                        <p>Password : <%= currentUser.getPASSWORD()%> <br />
                        <p>Address : <%= currentUser.getADDRESS()%> <br />
                        <p>Current Job : <%= currentUser.getCURRENT_JOB()%> <br />


                        <div id="content_bottom1">
                            <div class="content_bottom_container_boxl">
                                <div class="readmore1">
                                    <a href="UserController?action=edit&userId=<c:out value="<%= currentUser.getUSER_ID()%>"/>">Edit Profile</a>
                                </div><!--close readmore-->
                            </div><!--close content_bottom_container_box-->
                            <div class="content_bottom_container_boxl">
                                <div class="readmore1">
                                    <a href="BlogServlet?action=writeb">Write Blog</a>
                                </div><!--close readmore-->
                            </div><!--close content_bottom_container_box-->
                            <div class="content_bottom_container_boxl">
                                <div class="submit1">
                                    <a href = "UserLogoutServlet">Logout</a>
                                </div><!--close readmore-->	  
                            </div><!--close content_bottom_container_box1-->      
                        </div><!--close content_bottom-->  




                        <!--<h2><a href = "logout.php">Log Out</a></h2>-->

                    </div><!--close content_item-->
                </div><!--close content-->  
            </div><!--close site_content-->  

            <div id="content_bottom">
                <div class="content_bottom_container_box">
                    <h4>Latest Blog Post</h4>
                    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
                    <div class="readmore">
                        <a href="#">Read more</a>
                    </div><!--close readmore-->
                </div><!--close content_bottom_container_box-->
                <div class="content_bottom_container_box">
                    <h4>Latest News</h4>
                    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
                    <div class="readmore">
                        <a href="#">Read more</a>
                    </div><!--close readmore-->
                </div><!--close content_bottom_container_box-->
                <div class="content_bottom_container_box">
                    <h4>News Latter</h4>
                    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
                    <div class="readmore">
                        <a href="#">Read more</a>
                    </div><!--close readmore-->	  
                </div><!--close content_bottom_container_box1-->      
                <br style="clear:both"/>
            </div><!--close content_bottom-->   
        </div><!--close main-->

        <div id="footer">
            <a href="https://www.facebook.com/IUTPS/">IUTPS</a> | Copyright | <a href="http://facebook.com/muhaimenul">Muhaimenul Islam</a>
        </div><!--close footer--> 



    </body>
</html>