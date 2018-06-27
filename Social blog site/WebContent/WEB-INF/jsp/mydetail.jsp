<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blogbook</title>
</head>
<body>
	<div><h2><strong>Blogbook</strong></h2></div><br>
	<h3>Hello: ${username}</h3>
	<div>
		<table border="2" width="70%" cellpadding="2"> 
			<h3>Blogs Published</h3> 
			<tr><th>Blog name</th><th>Blog Creation Date</th><th>Content</th> <th> Username </th>
	   		<c:forEach var="blog" items="${listofblog}" >   
		   		<tr>  
		   			<td>${blog.blog_title}</td>  <td> ${blog.blog_creation_date}</td>  <td>${blog.blog_content}</td> <td>${blog.username}</td> 
		  	   </tr>  
	   		</c:forEach>  
   		</table>  
	</div>
	<br>
	<div>
		<table border="2" width="70%" cellpadding="2"> 
			<h3>Personal Detail</h3> 
			<tr><th>Firstname</th><th>Lastname</th><th>Username</th> <th> Address </th><th> Phone </th>
	   		<c:forEach var="x" items="${listofpersonaldetail}" >   
		   		<tr>  
		   			<td>${x.firstname}</td>  <td> ${x.lastname}</td>  <td>${x.username}</td> <td>${x.address}</td> <td> ${x.phone}</td> 
		  	   </tr>  
	   		</c:forEach>  
   		</table>  
	</div>
</body>
</html>