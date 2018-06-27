<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register Yourself</title>
	<link rel="stylesheet" href="StyleSheet.css">
</head>
<body id="h1">
	<div class="top_bar" >
			<div class="set_icon">
				<img src="Tulips.jpeg" height="30" width="30">
				<h1><strong>Blogbook</strong></h1>
			</div>
	</div>
	<div>
	<!-- username , password, first name, last name, address, phone -->
	<c:if test="${message}">
		<h3>${ message}</h3>
	</c:if>
		 
		<form:form method="post" action="save" >
				<table>
					<tr>
						<td>Enter user details....</td>
					</tr>
					<tr>    
          				<td>Firstname : </td>   
          				<td><input type="text" name="firstname"required></td>
         			</tr>
         			<tr>    
          				<td>Lastname : </td>   
          				<td><input type="text" name="lastname"   required></td> 
         			</tr>
         			<tr>    
          				<td>Address: </td>   
          				<td><input type="text" name="address"   required></td>  
         			</tr>
         			<tr>    
          				<td>Phone: </td>   
          				<td><input type="text" name="phone"   required></td>  
         			</tr>
         			<tr>    
          				<td>Password : </td>   
          				<td><input type="password" name="password" required></td>  
         			</tr> 
					<tr>
						<td></td>
						<td><input type="submit" value="Create Account" /></td>
					</tr>
				</table>
			</form:form>
			<form:form method="post" action="get_guidelines" >
				<br>Click Here to see the guideline how to create an account: <input type="submit" value="Get Guideline">
			</form:form>
			
		</div>
</body>
</html>