<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div><h2><strong>Blogbook</strong></h2></div><br>
	<h2> ${blog_title}</h2><br>
	<table border="2" width="70%" cellpadding="2">  
			
	   		<c:forEach var="blog" items="${list}" >   
		   		<tr>  
		   			<td>Blogname: ${blog.blog_title}</td>    
		  	   </tr>  
		  	   <tr>
		  	   		<td>Blog creation Date:  ${blog.blog_creation_date}</td>
		  	   </tr>
		  	   <tr>
		  	   		<td>Blog Created By: ${blog.username}</td> 
		  	   </tr>
		  	   <tr>
		  	   		<td>Content: ${blog.blog_content}</td> 
		  	   </tr>
	   		</c:forEach>  
   		</table>  
</body>
</html>