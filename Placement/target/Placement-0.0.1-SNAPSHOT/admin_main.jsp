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
                  <input type= "button" class="btn_add" value="Add Company" onclick="includefile('company');">
                  <div id="company" style="display: none;"><%@include file="company_registration.jsp" %></div>
                 
                     <%
                     
                        List<Company> cmp = (List<Company>) request.getAttribute("companies");

                       if(cmp.size()!=0) {
                         Iterator<Company> itr = cmp.iterator();
                     %>
                     <H3> List of company</H3>
                     <Hr width="25%" align="left"/>
                     <div class="cmplist">
                         <table>
                             <tr><th class="cmplisttd" align="left" width="10%">Company ID</th>
                             <th class="cmplisttd" align="left" width="10%">Name</th>
                             <th class="cmplisttd" align="left" width="10%">URL</th>
                             <th class="cmplisttd" align="left" width="5%">Stream</th>
                             <th class="cmplisttd" align="left" width="20%">Interview Date</th>
                             <th class="cmplisttd" align="left">Job profile</th>

                         </tr>
                        <%
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                         while(itr.hasNext()) {
                             Company cm = itr.next();
                             String id= cm.getCmp_id();
                             String name = cm.getCmp_name();
                             String url = cm.getCmp_url();
                             String stream = cm.getStream();
                             String interview = dateFormat.format(cm.getInterview());
                             String jobprofile = cm.getJobProfile();
                             String rd = request.getContextPath()+"/CompanyDetailServlet?com_id="+id;
                        %>
                        <tr>
                            <td class="cmplisttd" align="left" width="10%"><% out.print(id); %></td>
                            <td class="cmplisttd" align="left" width="10%"><a href="<%out.print(rd);%>"><% out.print(name); %></a></td>
                            <td class="cmplisttd" align="left" width="10%"><a href="https://www.google.co.in/"><% out.print(url); %></a></td>
                            <td class="cmplisttd" align="left" width="5%"><% out.print(stream); %></td>
                            <td class="cmplisttd" align="left" width="20%"><% out.print(interview); %></td>
                            <td class="cmplisttd" align="left" width="20%"><% out.print(jobprofile); %></td>

                        </tr>
                         <% }  %> 
                         </table>
                          <BR/>
                         <% } %>
                 </div>

                 
            </div>
              <%@include file="footer.html" %>
        </div>

    </body>
</html>
