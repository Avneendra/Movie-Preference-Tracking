<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Movies</title>
</head>
<body>
<h3>Hi ${fName}</h3>
<a href="login"> Recommendation</a>
<a href="Search"> Search</a>
<a href="MyLists-Ratings"> MyLists</a>
<a href="logout">Log out</a>
<a href="editprofile">Edit Profile</a>
<h3> Displaying movies in database</h3>
<p> Search for Movies Here </p>
<form action="SearchString" method="POST">
<input type="text" name="Search" value="Search"/>
<input type="submit" value="Search"/>
</form>
<h4> List of Movies </h4>
<form:form action="dbupdate" method="POST" modelAttribute="movieListWrapper">
<p> Sort by 
<select>
  <option value="AZ">A-Z</option>
  <option value="ZA">Z-A</option>
</select>
</p>
<table border="1" width="100%">
 <tr>
    <th>Movie Title</th>
    <th>Ratings</th>		
    <th>Ignore</th>
    <th>Wish</th>
 </tr>
<c:forEach items="${movieListWrapper.allmovies}"    var="movie"   varStatus="status" >  
<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
<td><form:input  path="allmovies[${status.index}].movieTitle"   value="${movie.movieTitle}" /></td>  
<td><form:input  type="number"  path="allmovies[${status.index}].ratings" min="1" max="5"  value="${movie.ratings}" /></td>  
<td><form:input  path="allmovies[${status.index}].ignore"    value="${movie.ignore}"/></td>  
<td><form:input  path="allmovies[${status.index}].wish"      value="${movie.wish}"/><br></td>
</tr>  
</c:forEach>  
</table>
<input type="submit" name="action" value="Save" />
<input type="submit" name="action" value="Cancel" />
</form:form>
</body>

</html>