<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blogbook</title>
<link rel="stylesheet" href="StyleSheet.css">
</head>
<body>

	<div>
		<div>
			<h2><strong>Blogbook</strong></h2>
		</div>
	</div>
	
	<form method="post" action="getpassword">
		  <h3>Enter your Username: </h3>
		  <input type="text" name="username" placeholder="Enter your username" required> <br><br> 
		  <input type="submit" value="Get password">
	</form>
	<h4><a href="index.jsp">LogIn</a></h4>
	<h4><a href="registration">Create a new Account</a></h4> 
</body>
</html>