<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
    	<form:form action="profile" method="post" modelAttribute="userForm">
            <center>
            <table border="1" >
                <thead>
                    <tr>
                        <th colspan="2">Edit User information</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><form:input path="fName" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><form:input path="lName"/></td>
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
                        <td><form:input path="password"/></td>
                    </tr>
     
                    <tr>
                        <td><input type="submit" name="action" value="Save" /></td>
                        <td><input type="submit" name="action" value="Cancel" /></td>
                    </tr>         
                </tbody>
            </table>
            </center>
         </form:form>
    </body>
</html>