<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
    	<form:form action="addAccount"  method="post" modelAttribute="userForm" name="userForm" onsubmit="return validate();">
            <center>
            <table border="1" >
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><form:input path="fName" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><form:input path="lName" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><form:input path="email" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><form:input path="userName" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><form:input type="password" path="password" /></td>
                    </tr>
     
                    <tr>
                        <td><input type="submit" name="action" value="Submit" /></td>
                        
                    </tr>         
                </tbody>
            </table>
            </center>
         </form:form>        
     </body>
    <script type="text/javascript">
      // Form validation code will come here.
      function validate()
      {
      
         if( document.userForm.fName.value == "" )
         {
            alert( "Please provide your First name!" );
            document.userForm.fName.focus() ;
            return false;
         }
         
         if( document.userForm.lName.value == "" )
         {
        	 alert( "Please provide your Last name!" );
            ddocument.userForm.lName.focus() ;
            return false;
         }
         
         if( document.userForm.email.value == "")
         {
            alert( "Please provide an email" );
            document.myForm.Zip.focus() ;
            return false;
         }
         
         if( document.userForm.userName.value == "" )
         {
            alert( "Please provide username" );
            return false;
         }
         if( document.userForm.password.value == "" )
         {
            alert( "Please provide Password" );
            return false;
         }
         return( true );
      }
 
		</script>
</html>