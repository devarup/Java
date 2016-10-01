<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*,com.placement.types.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration from</title>

<link type="text/css" href="style/placement_style.css" rel="stylesheet" />
 <script type="text/JavaScript" src="js/script.js"></script>
 <script type="text/JavaScript" src="js/jsdatepick-calendar.js"></script>

</head>

<body>
    <div class="main">
    <%@include file="header.html" %>
    <div class="mainbody">
        <div width="100%"  align="center" >
            <div style="height:77px;background-color: #127B9E;"><span class="style1"><u>REGISTRATION FORM </u></span></div>
        </div>
       

        <form action="RegistrationServlet" name="regform" method="post" >
            <div class="personal_detail">
                <div align="center" class="style6"><u>PERSONAL DETAIL</u> </div>
                <hr width="100%"/>
                <table class="pdetail_table">


                      <tr>
                         <td class="leftlebel">User-ID<span class="star">*</span>  </td>
                         <td class="rightinput"><input type="text" name="userid" size="30"/></td>
                       </tr>
                <tr>
                    <td class="leftlebel"> PASSWORD<span class="star">*</span></td>
                    <td class="rightinput"> <input type="password" name="password" size="15" /></td>
                </tr>
                <tr>
                    <td class="leftlebel">Confirm Password<span class="star">*</span></td>
                    <td class="rightinput"><input type="password" name="cnf_password" size="15" /></td>
                </tr>
                 <tr>
                    <td class="leftlebel">First name<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="f_name" size="30"/></td>
                 </tr>
                 
                  <tr>
                    <td class="leftlebel">Last Name<span class="star">*</span></td>
                    <td class="rightinput"> <input type="text" name="l_name" size="30"/></td>
                  </tr>
                  <tr>
                   <td class="leftlebel">Date of birth<span class="star">*</span></td>
                    <td class="rightinput"> <input type="text" name="dob" size="30"/>(<span>dd-mm-yyyy</span>)</td>
                  </tr>
                  <tr>
                    <td class="leftlebel">Gender<span class="star">*</span></td>
                    <td class="rightinput">
                      <label>
                      <input name="gender" type="radio" value="M" checked /> Male
                      <input name="gender" type="radio" value="F" />Female
                      </label>
                    </td>
                  </tr>
                  
                  <tr>
                    <td class="leftlebel">Address<span class="star">*</span></td>
                    <td class="rightinput"> <input type="text" name="address" size="70"/></td>
                  </tr>
                  <tr>
                    <td class="leftlebel">Contact Number 1<span class="star">*</span></td>
                    <td class="rightinput"> <input type="text" name="cont_1" size="15"/></td>
                  </tr>
                  <tr>

                    <td class="leftlebel">Contact Number 2</td>
                    <td class="rightinput"><input type="text" name="cont_2" size="15"/></td>
                  </tr>
                    <tr>
                    <td class="leftlebel">Email-Id<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="email_id" size="25"/></td>
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
                                   <option value="All">Select</option>
                                  <%
                                   StreamType st[] = StreamType.values();
                                    for (StreamType streamType : st) {
                                  %>
                                  <option value="<%= streamType.toString()%>"><%= streamType.toString() %></option>
                                  
                                  <% } %>
                                 
                              </select>


                          </td>
                      </tr>
                                  <tr id="specalization" style="display: none;">
                          <td class="leftlebel">Stream</td>
                          <td class="rightinput">
                              <select id="spec" name="spec" style="width:100px;" onchange="testAlert()">
                                   <option value="CSE">CSE</option>
                                   <option value="CE">CE</option>
                                   <option value="IT">IT</option>
                             </select>


                          </td>
                      </tr>


                      <tr>
                        <td class="leftlebel">Percentage<span class="style8">*</span></td>
                        <td class="rightinput"><input type="text" name="percentile" size="5"/>
                          </td>
                      </tr>
                      <tr>
                        <td class="leftlebel">College Name</td>
                        <td class="rightinput">
                            <input type="text" name="college" size="50" />
                        </td>
                      </tr>

                      <tr>
                          <td class="leftlebel">Board Name<span class="star">*</span></td>
                          <td class="rightinput"><input type="text" name="board" size="50"/></td>
                      </tr>


                      <tr>
                        <td class="leftlebel" style="font-size: 18px;">Higher Secondary(XII)</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td class="leftlebel">Marks<span class="style8">*</span></td>
                        <td class="rightinput"><input type="text" name="xii_marks" size="5"/>
                          <b>%</b></td>
                      </tr>
                      <tr id="math">
                          <td class="leftlebel">Maths as a subject<span class="star">*</span></td>
                          <td class="rightinput">
                              <input name="maths" type="radio" value="true" checked /> Yes
                              <input name="maths" type="radio" value="false" />No</td>
                      </tr>
                      <tr>
                        <td class="leftlebel">School Name</td>
                        <td class="rightinput">
                            <input type="text" name="xii_school" size="50" />
                        </td>
                      </tr>

                      <tr>
                          <td class="leftlebel">Board Name<span class="star">*</span></td>
                          <td class="rightinput"><input type="text" name="xii_board" size="50"/></td>
                      </tr>



                      <tr>
                              <td class="leftlebel" style="font-size: 18px;">Secondary( X )</td>
                          <td>&nbsp;</td>
                      </tr>
                      <tr>
                          <td class="leftlebel">Marks<span class="star">*</span></td>
                          <td class="rightinput"> <input type="text" name="x_marks" size="5"/><b>%</b></td>
                      </tr>
                      
                      <tr>
                        <td class="leftlebel">School Name</td>
                        <td class="rightinput">
                            <input type="text" name="x_school" size="50" />
                        </td>
                      </tr>
                      <tr>
                          <td class="leftlebel">Board Name<span class="star">*</span></td>
                          <td class="rightinput"><input type="text" name="x_board" size="50"/></td>                            
                      </tr>
                      
                    </table>
            </div>
<p align="center" class="style6">
  <label><input type="submit" name="Submit" value="Create My Account" />&nbsp;&nbsp;&nbsp;&nbsp;</label>
  <label><input type="button" name="cancel" value="Cancel" onclick="history.back()"/></label>
</p>
</form>


    </div>

     <%@include file="footer.html"%>
</div>
</body>
</html>
