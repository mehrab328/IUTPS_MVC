<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Members List</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/i_style.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/image_slide.js"></script>
        <link rel="stylesheet" href="css/style.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/calendar.js"></script>

        <script type="text/javascript">
            function myFunction(x) {
                var z = confirm("Are you sure you want to delete this member?");
                if (z) {
                    var y = "AdminController?action=delete&userId=" + x;
                    window.location = y;
                    return true;
                } else {
                    window.location = "AdminController?action=listuser1";
                    return false;
                }
            }
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
                        <h2>I was single then Photography came in my life</h2>
                    </div><!--close welcome-->
                    <!--<div id="welcome_slogan">
                      <h1>Photography came in my life (Slogan)</h1>
                    </div><!--close welcome_slogan-->
                </div><!--close banner-->
            </div><!--close header-->

            <div id="menubar">
                <nav class="menu">
                    <ul class="clearfix">
                        <li><a href="AdminController?action=index">Home</a></li>
                        <li><a href="AdminController?action=addMem">Add Member</a></li>
                        <li class="current-item"><a href="AdminController?action=listuser1">Member List</a></li>
                        <li><a href="AdminController?action=edit1">Update Info</a></li>
                        <li><a href="LogoutServlet" >Logout</a></li>
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
                            <p>PS Freshers. First year students shoudl be introduced with us.</p>         
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
                            <p>Break The Circle, Inter Photography Compitition of different univarsities.</p>         
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


                        <div class="list-scrol">

                            <table  border='1' bgcolor='#8cd9b3' class ='mem-table' style="border-collapse: collapse;" >

                                <thead>
                                    <tr>
                                        <th>Student ID</th>
                                        <th width='200px'>Name</th>
                                        <th>Department</th>
                                        <th>Mobile No</th>
                                        <th>E-mail</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                        <tr align='center'>
                                            <td><c:out value="${user.USER_ID}" /></td>
                                            <td><c:out value="${user.NAME}" /></td>
                                            <td><c:out value="${user.DEPT}" /></td>
                                            <td><c:out value="${user.PHONE}" /></td>
                                            <td><c:out value="${user.EMAIL}" /></td>
                                            <!--<td><a href="AdminController?action=edit&userId=<c:out value="${user.USER_ID}" />" >Update</a></td>-->
                                            <td><a href="javascript:myFunction('<c:out value="${user.USER_ID}"/>');" >Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>

                        </div>

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


    </div>
</body>
</html>