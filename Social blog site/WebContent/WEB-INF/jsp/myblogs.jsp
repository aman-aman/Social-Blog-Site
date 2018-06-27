<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blogbook</title>
</head>
<body>
	<h3>${message }</h3><br>
	<table border="2" width="70%" cellpadding="2">  
	<tr><th>Blog name</th><th>Blog Creation Date</th><th>Content</th><th>User</th>
   		<c:forEach var="blog" items="${list}">   
	   		<tr>  
	   			<td>${blog.blog_title}</td>  <td> ${blog.blog_creation_date}</td>  <td>${blog.blog_content}</td> <td>${blog.username}</td>   
	   			<td>
	   				<form method="post" action="getblogdetail/${blog.blog_title}/${blog.blog_creation_date }">
	   					<input type="submit" value="Details">
	   			    </form>
	   		   </td>   
	  	   </tr>  
   		</c:forEach>  
   </table>  
</body>
</html>