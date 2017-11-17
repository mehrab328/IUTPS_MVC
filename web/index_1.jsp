<%-- 
    Document   : index
    Created on : Sep 11, 2016, 9:46:30 PM
    Author     : Muhaimenul Islam
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
    <head>
        <title>IUTPS Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/i_style.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/image_slide.js"></script>
        <link rel="stylesheet" href="css/style.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/calendar.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#see").click(function (e) {
                    e.preventDefault();
                    $("#tog").toggle();
                });

                $("#see1").click(function (e) {
                    e.preventDefault();
                    $("#tog1").toggle();
                });
            });
        </script>
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
                </div><!--close banner-->
            </div><!--close header-->

            <div id="menubar">
                <nav class="menu">
                    <ul class="clearfix">
                        <li  class="current-item"><a href="AdminController?action=index">Home</a></li>
                        <li><a href="AdminController?action=addMem">Add Member</a></li>
                        <li><a href="AdminController?action=edit1">Update Info</a></li>
                        <li><a href="#">Information<span class="arrow">&#9660;</span></a>
                            <ul class="sub-menu">
                                <li><a href="AdminController?action=listuser1">Member List</a></li>
                                <li><a href="gallary.jsp">Gallery</a></li>
                                <li><a href="BlogServlet?action=listBlog">Blogs</a></li>
                            </ul>
                        </li>

                        <li><a href="LogoutServlet" >Logout</a></li>
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

                    <div class="sidebar">
                        <div class="sidebar_item">
                            <div>
                                <div><h2>Calendar</h2></div>
                                <div class="jquery-calendar"></div>
                            </div>
                        </div><!--close sidebar_item--> 
                    </div><!--close sidebar--> 		
                </div><!--close sidebar_container-->	

                <div class="slideshow">
                    <ul class="slideshow">
                        <li class="show"><img width="680" height="250" src="images/001.jpg" alt="&quot;Preparation of 2nd Intra IUT Photography Exhibition of 2015&quot;" /></li>
                        <li><img width="680" height="250" src="images/002.jpg" alt="&quot;IUT&quot;" /></li>
                    </ul>
                </div> 

                <!--<div class="slideshow">
                    <ul class="slideshow">
                  <li class="show"><img width="680" height="250" src="images/001.jpg" alt="&quot;Preparation of 2nd Intra IUT Photography Exhibition of 2015&quot;" /></li>
                  <li><img width="680" height="250" src="images/002.jpg" alt="&quot;IUT&quot;" /></li>
                </ul>
              </div>   -->  

                <div id="content">
                    <div class="content_item">
                        <br/><br/><h1>Welcome To IUTPS ADMIN PAGE</h1> 
                        <br/><br/><p>A platform for IUTians to exercise their creativity, IUTPS was formed in 2010 through the hands of some enthusiastic photographers.Since then it has grown from a handful of members to 104 active members and 45 ex-members who also participates with us in activities such as workshops, photo walks, photo addas etc.
                        </p>	  
                        <br/> <p>The moment of glory for IUTPS came in 2011 when IUTPS organized an international inter-university photography exhibition. With participants from 11 international and 30 national universities the event was a success. 

                            Since, its birth IUTPS has come a long way. Despite being a young organisation IUTPS promises to have a large impact in the photography scene of the nation.
                        </p>
                        <br/><br/><br/>
                        <div class="content_container">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.<span id="tog" style="display:none;">Since, its birth IUTPS has come a long way. Despite being a young organisation IUTPS promises to have a large impact in the photography scene of the nation.
                                </span></p>
                            <div class="button_small">
                                <a href="#" id="see">Read more</a>
                            </div><!--close button_small-->
                        </div><!--close content_container-->
                        <div class="content_container">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.<span id="tog1" style="display:none;">Since, its birth IUTPS has come a long way. Despite being a young organisation IUTPS promises to have a large impact in the photography scene of the nation.
                                </span></p>          
                            <div class="button_small">
                                <a href="#" id="see1">Read more</a>
                            </div><!--close button_small-->		  
                        </div><!--close content_container-->			  
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
            <a href="https://www.facebook.com/IUTPS/">IUTPS </a> |  <a href="admin_log.jsp" > Admin Panel</a>
        </div><!--close footer--> 


    </body>
</html>