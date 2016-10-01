<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="style/placement_style.css" rel="stylesheet" />
        <script type="text/JavaScript" src="js/script.js"></script>
    </head>

    <body>
        <% (session).invalidate();%>
        

        <div class="main">
            <%@include file="header.html" %>
            
            <div class="mainbody">


                <div style="float : left; background-image: url(images/bgpsd2.jpg); width: 645px; height: 465px; " >
                    
                    <span> <h2 align="center"  style="margin: 150px 0 0 50px; color: #000;">

                            Welcome to Official website of <BR> TECHNO INDIA GROUP PLACEMENT CELL.
                            <Br>
                            This website is created to provide information
                            about the latest campus related activities of Techno India Group.
                        </h2>
                    </span>>
                       

                </div>
                <div style="float:right;margin: 35px 0 35px 0;height: 400px;" >
                    <form action="LoginServlet" name="loginform" method="post" onsubmit="return validate()">
                

                    <div class="login" style="width: 350px;">
                        <div style="margin:20px 20px; background-color: #A5BCD1;">
                        <BR>
                        <div id="errormsg" class="errormsg" align="center"><%if(request.getAttribute("message")!= null)
                                out.print(request.getAttribute("message"));
                           %></div>
                        <BR>
                            <div class="loginlabel">UserID</div><div class="logininput"><input type="text" name="user_id" value="" size="20"></div>
                        <div style="clear: both"></div>
                        <div class="loginlabel">Password</div><div class="logininput"><input type="password" name="password" size="20"></div>
                        <div style="clear: both"></div>
                        <center> <input type= "submit" class="btn_submit" value="LOGIN" ></center><br>
                        </div>
                        <div style="clear: both;"></div>
                        <div align="center">
                        <b>New account >> </b>
                        <a href="registration.jsp" style="color: #264A6B;">Register</a>
                        </div>
                    </div>

                </form>
                </div>
            </div>
            <div style="clear: both;"></div>
            <%@include file="footer.html" %>
        </div>
        
    </body>
</html>
