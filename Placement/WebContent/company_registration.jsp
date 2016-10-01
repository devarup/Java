 
        <form action="CompanyRegiServlet" name="regform" method="post" >
            <div>

                <table>
                      <tr>
                         <td class="leftlebel">Company-ID<span class="star">*</span>  </td>
                         <td class="rightinput"><input type="text" name="cmp_id" size="30"/></td>
                       </tr>
                <tr>
                <tr>
                    <td class="leftlebel"> Company Name<span class="star">*</span></td>
                    <td class="rightinput"> <input type="text" name="cmp_name" size="40" /></td>
                </tr>
                <tr>
                    <td class="leftlebel">Company URL<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="cmp_url" size="15" /></td>
                </tr>
                 <tr>
                    <td class="leftlebel">Company Detail<span class="star">*</span></td>
                    <td class="rightinput"><textarea rows="4" cols="50" name="cmp_detail"></textarea></td>
                 </tr>

                 <tr>
                    <td class="leftlebel">Xii Marks<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="xii_marks" size="15" /></td>
                 </tr>

                 <tr>
                    <td class="leftlebel">X Marks<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="x_marks" size="15" /></td>
                 </tr>
                 <tr>
                    <td class="leftlebel">Stream<span class="star">*</span></td>
                    <td class="rightinput">


                     <input type="radio"  name="stream" value="Bca" checked onclick="companySpecFilter()">Bca<br>
                     <input type="radio"  name="stream" value="Btech"  onclick="companySpecFilter()">Btech

                        <select id="spec" name="spec" style="width:100px; display: none;">
                                   <option value="CSE">CSE</option>
                                   <option value="CE">CE</option>
                                   <option value="IT">IT</option>
                        </select>
                       </td>

                 </tr>

                 <tr>
                    <td class="leftlebel">Interview Date<span class="star">*</span></td>
                    <td class="rightinput"><input type="text" name="interview" size="15" />
                    </td>
                 </tr>
                 <tr>
                    <td class="leftlebel">Job Profile<span class="star">*</span></td>
                    <td class="rightinput"><textarea rows="4" cols="50" name="profile"></textarea>
                    </td>
                 </tr>

                </table>
               
            </div>
            <HR width="100%"/>
            <label><input type="submit" name="Submit" value="Save" /></label>
            <label><input type="button" name="Cancel" value="Cancel" onclick="hidedisplay('company')"/></label>

        </form>


<script>
      function companySpecFilter(){
              var radios = document.getElementsByName('stream');
              var val = "";
              for (var i = 0, length = radios.length; i < length; i++) {
                  if (radios[i].checked) {
                      val =  radios[i].value;
                  }
               }

               if(val == "Bca")
                 document.getElementById("spec").style.display = "none";
                else
                 document.getElementById("spec").style.display = "block";

         }
</script>
