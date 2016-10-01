<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*,com.placement.types.*,com.placement.app.Student,java.text.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Career@Techno</title>

<link type="text/css" href="style/placement_style.css" rel="stylesheet" />
 <script type="text/JavaScript" src="js/script.js"></script>
 <script type="text/JavaScript" src="js/jsdatepick-calendar.js"></script>

</head>

<body>
    <div class="main">
    <%@include file="header.html" %>
    <div class="mainbody">
        <div align="right">
                     <ul id="menu">
                             <li><a href="index.jsp">Log out</a></li>
                        </ul>
                 </div>
        <BR/>
        
        <%Student stu = (Student) request.getAttribute("student");%>
        
       <form action="UpdateServlet" name="updateform" method="post" >
            <div class="personal_detail">
                <div align="center" class="style6"><u>PERSONAL DETAIL</u> </div>
                <hr width="100%"/>
                <table class="pdetail_table">


                      <tr>
                         <td class="leftlebel">User-ID<span class="star">*</span>  </td>
                         <td class="rightinput"><input type="text" readonly name="userid" size="30" value="<%= stu.getUserid()%>"/></td>
                       </tr>
                
                 <tr>
                    <td class="leftlebel">First name</td>
                    <td class="rightinput"><input type="text" readonly name="f_name" size="30" value="<%= stu.getF_name()%>"/></td>
                 </tr>

                  <tr>
                    <td class="leftlebel">Last Name</td>
                    <% %>
                    <td class="rightinput"> <input type="text" readonly name="l_name" size="30" value="<%= stu.getL_name()%>"/></td>
                  </tr>
                  <tr>
                      <%
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                          String date = dateFormat.format(stu.getDob());  %>
                   <td class="leftlebel">Date of birth</td>
                   <td class="rightinput"> <input type="text" readonly name="dob" size="30" value="<%= date%>"/>(<span>dd-mm-yyyy</span>)</td>
                  </tr>
                  <tr>
                    <td class="leftlebel">Gender</td>
                    <td class="rightinput">
                      <label>
                      <input name="gender" type="radio" value="M" <% if(stu.getGender().equalsIgnoreCase("M")){ %> checked <% }%> /> Male
                      <input name="gender" type="radio" value="F" <% if(stu.getGender().equalsIgnoreCase("F")){ %> checked <% }%>/>Female
                      </label>
                    </td>
                  </tr>

                  <tr>
                    <td class="leftlebel">Address</td>
                    <td class="rightinput"> <input type="text" name="address" size="70" value="<%= stu.getAddress()%>"/></td>
                  </tr>
                  <tr>
                    <td class="leftlebel">Contact Number 1</td>
                    <td class="rightinput"> <input type="text" name="cont_1" size="15" value="<%= stu.getCont_1() %>"/></td>
                  </tr>
                  <tr>

                    <td class="leftlebel">Contact Number 2</td>
                    <td class="rightinput"><input type="text" name="cont_2" size="15" value="<%= stu.getCont_2() %>" /></td>
                  </tr>
                    <tr>
                    <td class="leftlebel">Email-Id</td>
                    <td class="rightinput"><input type="text" name="email_id" size="25" value="<%= stu.getEmail_id()%>" /></td>
                  </tr>
          </table>
        </div>
            <BR/>
            <div class="edu_detail">
                 <div align="center" class="style6"><u>EDUCATIONAL DETAIL </u></div>
                  <hr width="100%"/>
                  <table class="edetail_table">

                      <tr>
                          <td class="leftlebel"> Highest Degree</td>
                          <td class="rightinput">
                              <select id="stream" name="stream" style="width:100px;" onchange="testAlert()">
                                   <option value="">Select</option>
                                  <%
                                   StreamType st[] = StreamType.values();
                                    for (StreamType streamType : st) {
                                  %>
                                  <option  value="<%= streamType.toString()%>" <% if(stu.getStream().equalsIgnoreCase(streamType.toString())){%> selected="selected" <% } %>><%= streamType.toString() %></option>

                                  <% } %>

                              </select>


                          </td>
                      </tr>

                      <tr>
                        <td class="leftlebel">Percentage</td>
                        <td class="rightinput"><input type="text" name="percentile" size="5" value="<%= stu.getPercentile()%>"/>
                          </td>
                      </tr>
                      <tr>
                        <td class="leftlebel">College Name</td>
                        <td class="rightinput">
                            <input type="text" name="college" size="50" value="<%= stu.getCollege()%>" />
                        </td>
                      </tr>

                      <tr>
                          <td class="leftlebel">Board Name<span class="star">*</span></td>
                          <td class="rightinput"><input type="text" name="board" size="50" value="<%= stu.getBoard()%>"/></td>
                      </tr>


                      <tr>
                        <td class="leftlebel" style="font-size: 18px;">Higher Secondary(XII)</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td class="leftlebel">Marks</td>
                        <td class="rightinput"><input type="text" name="xii_marks" size="5" value="<%= stu.getXii_marks()%>"/>
                          <b>%</b></td>
                      </tr>
                        <tr id="math" <% if(stu.getStream().equalsIgnoreCase("Btech")){%>  style="display: none;" <%}%>>
                          <td class="leftlebel">Maths as a subject</td>
                          <td class="rightinput">
                              <input name="maths" type="radio" value="true" <% if(stu.getMaths() == true) {%> checked <%}%> /> Yes
                              <input name="maths" type="radio" value="false" <% if(stu.getMaths() == false) {%> checked <%}%> />No</td>
                      </tr>
                      <tr>
                        <td class="leftlebel">School Name</td>
                        <td class="rightinput">
                            <input type="text" name="xii_school" size="50" value="<%= stu.getXii_school()%>" />
                        </td>
                      </tr>

                      <tr>
                          <td class="leftlebel">Board Name</td>
                          <td class="rightinput"><input type="text" name="xii_board" size="50" value="<%= stu.getXii_board()%>"/></td>
                      </tr>



                      <tr>
                              <td class="leftlebel" style="font-size: 18px;">Secondary( X )</td>
                          <td>&nbsp;</td>
                      </tr>
                      <tr>
                          <td class="leftlebel">Marks</td>
                          <td class="rightinput"> <input type="text" name="x_marks" size="5" value="<%= stu.getX_marks()%>"/><b>%</b></td>
                      </tr>

                      <tr>
                        <td class="leftlebel">School Name</td>
                        <td class="rightinput">
                            <input type="text" name="x_school" size="50" value="<%= stu.getX_school()%>"/>
                        </td>
                      </tr>
                      <tr>
                          <td class="leftlebel">Board Name</td>
                          <td class="rightinput"><input type="text" name="x_board" size="50" value="<%= stu.getX_board()%>"/></td>
                      </tr>

                    </table>
                      <input type="hidden" name="action" value="save"/>

            </div>
<p align="center" class="style6">
  <label><input type="submit" name="Submit" value="save" />&nbsp;&nbsp;&nbsp;&nbsp;</label>
  <label><input type="button" name="cancel" value="Cancel" onclick="history.back()"/></label>
</p>
</form>


    </div>

     <%@include file="footer.html"%>
</div>
</body>
</html>
