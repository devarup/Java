/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


 function validate()
            {
        
                var uid =document.loginform.user_id.value;
                var pwd =document.loginform.password.value;
               
                if(uid == '')
                {
                
                    document.getElementById("errormsg").innerHTML = "Please type user id";
                    return false;//wl nt move in servletpage if return false
                }
                if(pwd == '')
                {
                    document.getElementById("errormsg").innerHTML = "Please type password";
                    return false;
                }
            }

 function testAlert(){

     var val = document.getElementById("stream").value;

     if(val == "Bca")
         {
         document.getElementById("math").style.display = "block";
          document.getElementById("specalization").style.display = "none";
          document.getElementByName("spec").value = "none";
         }
     else if(val == "Btech")
        {
            document.getElementById("specalization").style.display = "block";
            document.getElementById("math").style.display = "none";
            document.getElementsByName("maths").value = "true";
        }
        else {

             document.getElementById("specalization").style.display = "none";
             document.getElementById("math").style.display = "none";

        }

 }

 function includefile()
                {
                    document.getElementById("company").style.display="block";
                }

function hidedisplay()
    {
     document.getElementById("company").style.display="none";
   }

   function includefile(ids)
                {
                    document.getElementById(ids).style.display="block";
                }

function hidedisplay(ids)
    {
     document.getElementById(ids).style.display="none";
   }


function validateUserRegistration(){


        var uid = document.regform.userid.value;
        var password = document.regform.password.value;
        var cnf_password = document.regform.cnf_password.value;
        var f_name = document.regform.f_name.value;
        var l_name = document.regform.l_name.value;
        var dob = document.regform.dob.value;
        var address = document.regform.address.value;
        var cont = document.regform.cont.value;
        var email_id = document.regform.email_id.value;
        if(uid == '' || password == '' || cnf_password == '' || f_name == ''
           || l_name == '' || dob == '' || address == '' || cont == '' || email_id == '')
            {
                alert("Please input all the field");
                return false;

            }

       
}