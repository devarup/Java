<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,com.placement.app.*,java.text.SimpleDateFormat" %>
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
             <div class="mainbody">
                 <HR width="100%"/>
                 <H2 align="center">Administrator</H2>
                 <HR width="100%"/>
                 <div align="right">
                     <ul id="menu">
                         
                            <li><a href="<%=request.getContextPath()%>/LoginServlet">Company</a></li>
                            <li><a href="<%=request.getContextPath()%>/StudentServlet">Student</a></li>
                            <li><a href="index.jsp">Log out</a></li>
                        </ul>
                 </div>
                 <div style="clear: both;"></div>

                     <%
                       SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                       List<Student> stu = (List<Student>) request.getAttribute("std_list");
                       List<Student> stu_not_list = (List<Student>) request.getAttribute("std_not_list");

                       if(stu.size() == 0 && stu_not_list.size() == 0) { %>

                       <H1> No Student get short listed till now </H1>

                       <% }
                       if(stu.size()!= 0) {
                              Iterator<Student> itr = stu.iterator();
                           %>

                       <H3> Short listed student detail </H3>
                       <Hr width="25%" align="left"/>
                        <div class="stulist">
                         <table width="100%">
                             <tr><th class="stulisttd" align="left" width="20%">User id</th>
                             <th class="stulisttd" align="left" width="20%">Name</th>
                             <th class="stulisttd" align="left" width="10%">Date of birth</th>
                             <th class="stulisttd" align="left" width="10%">Gender</th>
                             <th class="stulisttd" align="left" width="10%">Email id</th>
                             <th class="stulisttd" align="left" width="10%">Address</th>
                             <th class="stulisttd" align="left" width="10%">contact_1</th>
                           </tr>
                        <%
                        
                         while(itr.hasNext()) {
                             Student st = itr.next();
                             String user_id = st.getUserid();
                             String name1 = st.getF_name()+" "+st.getL_name();
                             String dob = dateFormat.format(st.getDob());
                             String gender = st.getGender();
                             gender = gender.equalsIgnoreCase("M")?"Male" :"Female";
                             String email_id = st.getEmail_id();
                             String add = st.getAddress();
                             String contact = st.getCont_1();
                                                          
                        %>
                        <tr>
                            <td class="stulisttd" align="left"><% out.print(user_id); %></td>
                            <td class="stulisttd" align="left"><% out.print(name1); %></td>
                            
                            <td class="stulisttd" align="left"><% out.print(dob); %></td>
                            <td class="stulisttd" align="left"><% out.print(gender); %></td>
                            <td class="stulisttd" align="left"><% out.print(email_id); %></td>
                            <td class="stulisttd" align="left"><% out.print(add); %></td>
                            <td class="stulisttd" align="left"><% out.print(contact); %></td>
                            
                            
                        </tr>
                         <% }  %>
                         </table>
                          <BR/>
                         <% } %>

                          <% if(stu_not_list.size()!= 0) {
                              Iterator<Student> itr = stu_not_list.iterator();
                           %>
                 </div>
                  <H3> Not short listed student detail </H3>
                 <div class="notshortlisted">
                    
                       <Hr width="25%" align="left"/>
                        <div class="stulist">
                         <table width="100%">
                             <tr><th class="stulisttd" align="left" width="20%">User id</th>
                             <th class="stulisttd" align="left" width="20%">Name</th>
                             <th class="stulisttd" align="left" width="10%">Date of birth</th>
                             <th class="stulisttd" align="left" width="10%">Gender</th>
                             <th class="stulisttd" align="left" width="10%">Email id</th>
                             <th class="stulisttd" align="left" width="10%">Address</th>
                             <th class="stulisttd" align="left" width="10%">contact_1</th>
                           </tr>
                        <%

                         while(itr.hasNext()) {
                             Student st = itr.next();
                             String user_id = st.getUserid();
                             String name1 = st.getF_name()+" "+st.getL_name();
                             String dob = dateFormat.format(st.getDob());
                             String gender = st.getGender();
                             gender = gender.equalsIgnoreCase("M")?"Male" :"Female";
                             String email_id = st.getEmail_id();
                             String add = st.getAddress();
                             String contact = st.getCont_1();

                        %>
                        <tr>
                            <td class="stulisttd" align="left"><% out.print(user_id); %></td>
                            <td class="stulisttd" align="left"><% out.print(name1); %></td>

                            <td class="stulisttd" align="left"><% out.print(dob); %></td>
                            <td class="stulisttd" align="left"><% out.print(gender); %></td>
                            <td class="stulisttd" align="left"><% out.print(email_id); %></td>
                            <td class="stulisttd" align="left"><% out.print(add); %></td>
                            <td class="stulisttd" align="left"><% out.print(contact); %></td>


                        </tr>
                         <% }  %>
                         </table>
                          <BR/>
                         <% } %>


                 </div>
 </div>
                   
            </div>

            <div id="company" style="display: none;"><%@include file="company_registration.jsp" %></div>
            <%@include file="footer.html" %>
        </div>

    </body>
</html>
