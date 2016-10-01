<%@page contentType="text/html" pageEncoding="UTF-8" import="com.placement.app.Student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Career@Techno</title>
        <link type="text/css" href="style/placement_style.css" rel="stylesheet" />
        <script type="text/JavaScript" src="js/script.js"></script>
    </head>
    <body>
        <div class="main">
            <%@include file="header.html" %>
             <div class="mainbody">
                 <HR width="100%"/>
                 <div align="right">
                     <ul id="menu">
                         <li><a href="index.jsp">Log out</a></li>                            
                        </ul>
                 </div>
                 <div style="clear: both;"></div>
                 
             </div>
                        
                 
                 <Br><br>
             <div class="profile">
                 <a href="<%=request.getContextPath()%>/StatusServlet?uid=<%=(String)request.getAttribute("stu_id")%>">Check status</a>

                 <% if(request.getAttribute("student") != null){
                     Student stu = (Student)request.getAttribute("student");

                     String id = stu.getUserid();
                     String fname = stu.getF_name();
                     String lname = stu.getL_name();
                     String stream = stu.getStream();
                     String email = stu.getEmail_id();
                     String gender = stu.getGender();
                     String cont = stu.getCont_1();
                  %>
                  <H3>Profile Detail</H3>
                  <Hr width="100%"/>
                    <table width="80%">
                        <tr>
                            <td class="" width="25%" align="left">ID</td>
                            <td class="" align="left"><% out.print(id); %></td>
                        </tr>
                        <tr>
                            <td class="" width="25%" align="left">First Name</td>
                            <td class="" align="left"><% out.print(fname); %></td>
                        </tr>
                        <tr>
                            <td class="" width="25%" align="left">Last Name</td>
                            <td class="" align="left"><% out.print(lname); %></td>
                        </tr>

                        <tr>
                            <td class=""  width="25%" align="left">Stream</td>
                            <td class=""   align="left"><% out.print(stream); %></td>
                        </tr>
                        <tr>
                            <td class="" width="25%" align="left">Email</td>
                            <td class="" align="left"><% out.print(email); %></td>
                        </tr>

                        <tr>
                            <td class="" align="left" width="25%">Contact no</td>
                            <td class="" align="left"><% out.print(cont); %></td>
                        </tr>
                         </table>
                        <Hr width="100%"/>
                        <a href="<%=request.getContextPath()%>/UpdateServlet?action=update&user_id=<%out.print(id);%>" name="update">Update</a>
                 <% } %>
                 
             </div>
               <%@include file="footer.html" %>
        </div>
    </body>
</html>
