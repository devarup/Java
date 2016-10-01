<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Careers@Techno</title>
        <link type="text/css" href="style/placement_style.css" rel="stylesheet" />
        <script type="text/JavaScript" src="js/script.js"></script>
    </head>
    <body>
        <div class="main">
            
            <%@include file="header.html" %>
            <Hr width="100%">
            
                 <div align="right">
                     <ul id="menu">
                            <li><a href="index.jsp">Log out</a></li>
                        </ul>
                 </div>
                 <div style="clear: both;"></div>

            <div class="mainbody">
                <BR><BR>
                <h4>Welcome <%= (String)session.getAttribute("name")%>. You have successfully registered in </h4><h3>Career@Techno.</h3>
                <h4>We will be in touch with you as long as you stay with us. Keep signing in your a/c regularly.</h4>

                <Br>
                <h4>Thanks & Regrads <BR>
                Team Career@Techno.
                </h4>


            </div>
         <%@include file="footer.html" %>
        </div>
    </body>
</html>
