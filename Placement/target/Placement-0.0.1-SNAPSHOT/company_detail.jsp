<%@page contentType="text/html" pageEncoding="UTF-8" import="com.placement.app.*,java.text.SimpleDateFormat,java.util.*,java.text.SimpleDateFormat"%>
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
                       Company cmp = null;
                       SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                       String job_id = (String)request.getAttribute("jobID");
                       if(request.getAttribute("company")!= null) {
                         cmp = (Company)request.getAttribute("company");
                        
                     %>
                     <H3> Company detail</H3>
                     <Hr width="25%" align="left"/>
                     <div>
                         <table width="80%">
                        <tr>
                            <td class="cmplisttd" width="25%" align="left">Company id</td>
                            <td class="cmplisttd" align="left"><% out.print(cmp.getCmp_id()); %></td>
                        </tr>
                        <tr>
                            <td class="cmplisttd" width="25%" align="left">Company Name</td>
                            <td class="cmplisttd" align="left"><% out.print(cmp.getCmp_name()); %></td>
                        </tr>
                        <tr>
                            <td class="cmplisttd" width="25%" align="left">Company Detail</td>
                            <td class="cmplisttd" align="left"><% out.print(cmp.getCmp_url()); %></td>
                        </tr>

                        <tr>
                            <td class="cmplisttd"  width="25%" align="left">Xii Marks</td>
                            <td class="cmplisttd"   align="left"><% out.print(cmp.getXii_marks()); %></td>
                        </tr>
                        <tr>
                            <td class="cmplisttd" width="25%" align="left">X Marks</td>
                            <td class="cmplisttd" align="left"><% out.print(cmp.getX_marks()); %></td>
                        </tr>
                        
                        <tr>
                            <td class="cmplisttd" align="left" width="25%">Stream</td>
                            <td class="cmplisttd" align="left">
                              <% out.print(cmp.getStream()); %> ,<% out.print(cmp.getSpec()); %>

                            </td>
                        </tr>
                        <tr>
                             <td class="cmplisttd">Job Profile</td>
                            <td class="cmplisttd"><% out.print(cmp.getJobProfile()); %>
                        </tr>
                        <tr>
                             <td class="cmplisttd">Interview Date</td>
                             <td class="cmplisttd"><% out.print(dateFormat.format(cmp.getInterview())); %>
                        </tr>
                         </table>
                        <Hr width="100%">
                          <BR/>
                         <% } %>

                       </div>

                         <div class="post_job_list" style="display: none;">

                             <% if(request.getAttribute("job_post")!=null){
                                List<Job> jobs = (List<Job>) request.getAttribute("job_post");
                                Iterator<Job> itr = jobs.iterator();
                                %>
                                <H3> Job posted</H3>
                                <Hr width="25%" align="left"/>
                                <table>
                                    <tr>
                                        <th align="left">Job Id</th>
                                        <th align="left">Profile</th>
                                        <th align="left">Description</th>
                                        <th align="left">Interview</th>
                                        <th align="left">Stream</th>
                                    </tr>
                                     <%
                                     
                                while(itr.hasNext()) {
                                     Job jb = itr.next();
                                    String id= jb.getJob_id();
                                    String profile =jb.getProfile();
                                    String desc = jb.getDescription();
                                    String interview = dateFormat.format(jb.getInterview());

                                    String stream =jb.getStream();
                                    if(stream.equalsIgnoreCase("Both"))
                                        stream ="Bca,Btech";
                                    else if(stream.equalsIgnoreCase("None"))
                                        stream = "Not specified";
                                    
                                 %>
                                   <tr>
                                        <td width="10%"><%= id%></td>
                                        <td width="20%"><%= profile%></td>
                                        <td width="30%"><%= desc%></td>
                                        <td width="10%"><%= interview%></td>
                                        <td width="10%"><%= stream   %></td>
                                    </tr>
                                       <% } %>
                                </table>
                                <hr width="100%">
                                <% }%>



                         </div>
                         <!--div>
                             
                             <input type= "button" class="btn_add" value="Add Job" onclick="includefile('job');"/>
                             <input type= "submit" class="btn_add" value="Back" onclick="form.action='LoginServlet?user_id=<%= (String)session.getAttribute("uid")%>&password=<%= (String)session.getAttribute("pwd")%>';">
                         </div-->
                         <div id="job" style="display: none;">
                             <jsp:include page="jobs.jsp">
                                 <jsp:param name="cmp_id" value="<%= cmp.getCmp_id() %>"/>
                                 <jsp:param name="jobID" value="<%= job_id %>"/>
                                
                             </jsp:include>
                         </div>



                 


            </div>
         <%@include file="footer.html" %>
        </div>
    </body>
</html>
