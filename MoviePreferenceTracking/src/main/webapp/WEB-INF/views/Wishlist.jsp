<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Hi ${fName}</h3>

<a href="login"> Recommendation</a>
<a href="Search"> Search</a>
<a href="MyLists-Ratings"> MyLists</a>
<a href="logout">Log out</a>
<a href="editprofile">Edit Profile</a>
<h3> Displaying My Lists </h3>
<a href="MyLists-Ratings"> Ratings List</a>
<a href="Wish"> Wish List</a>
<a href="Ignore"> Ignore list</a>
<h4> List of Movies in Wish List</h4>
<table border="1" width="100%">
 <tr>
    <th>Movie Title</th>
    <th>Ratings</th>		
    <th>Ignore</th>
    <th>Wish</th>
 </tr>
<c:forEach items="${movies}" var="movie">  
<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
<td><c:out value="${movie.movieTitle}"/></td>  
<td><input type="number" name="ratings" min="1" max="5" value="${movie.ratings}"></td>  
<td><input type="radio" name="ignore" value="${movie.ignore}"></td>  
<td><input type="radio" name="wish" value="${movie.wish}"><br></td>
</tr>  
</c:forEach>  
</table>
<form action="dbupdate" method="POST">
<input type="submit" name="action" value="Save" />
<input type="submit" name="action" value="Cancel" />
</form>  
</body>
</html>