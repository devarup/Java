<form action="JobServlet" method="post" name="jobform">
    <div>
        <input type="text" name="cmp_id" value="<%= request.getParameter("cmp_id")%>"/>
        
        <table>
                      <tr>
                         <td class="leftlebel">Job ID<span class="star">*</span>  </td>
                         <td class="rightinput"><input type="text" readonly name="job_id" size="30" value="<%= request.getParameter("jobID")%>"/></td>
                         
                       </tr>
                <tr>
                <tr>
                    <td class="leftlebel"> Job Profile <span class="star">*</span></td>
                    <td class="rightinput"> <input type="text" name="profile" size="40" /></td>
                </tr>
                <tr>
                    <td class="leftlebel">Description<span class="star">*</span></td>
                    <td class="rightinput">
                        <textarea rows="4" cols="50" name="description"></textarea>
                    </td>
                </tr>
                 <tr>
                    <td class="leftlebel">Interview Date<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="interview" size="15" />                     
                    </td>
                 </tr>

                 <tr>
                    <td class="leftlebel">Stream<span class="star">*</span></td>
                    <td class="rightinput"><input type="checkbox" name="stream" value="Bca">Bca<br>
                     <input type="checkbox" name="stream" value="Btech">Btech</td>
                 </tr>
                </table>

            </div>
            <HR width="100%"/>
            <label><input type="submit" name="Submit" value="Save" /></label>
            <label><input type="button" name="Cancel" value="Cancel" onclick="hidedisplay('job')"/></label>
</form>
