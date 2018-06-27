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
	<div>
		<div><h2><strong>Blogbook</strong></h2></div><br>
		<h4>${message }</h4>
		<table border="2" width="70%" cellpadding="2">  
	   		<c:forEach var="user" items="${list}" >   
		   		<tr>  
		   			<td>Username: </td> <td>${user.username}</td> <br> <td>Password: </td>  <td> ${user.password}</td>  
		  	   </tr>  
	   		</c:forEach>  
   		</table>  
	</div>
	<h4><a href="index.jsp">LogIn</a></h4>
	<h4><a href="registration">Create a new Account</a></h4>
</body>
</html>