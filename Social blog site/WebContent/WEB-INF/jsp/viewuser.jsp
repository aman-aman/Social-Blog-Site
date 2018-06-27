<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- this page will contain all blogs of user -->
<body>
	<div><h2><strong>Blogbook</strong></h2></div><br>
	<h2>Hello: ${username}</h2><br>
	<table>
		<tr>
			<td>
				<form method="post" action="allblog">
					<input type="submit" name="allblog" value="All Blog">
				</form>
			</td>
			<td>
				<form method="post" action="edituser/${username}">
					<input type="submit" name="edituser" value="Edit Data">
				</form>
			</td>
			<td>
				<form method="post" action="logout">
					
					<input type="submit" name="logout" value="Logout">
				</form>
			</td>
			<td>
				<form method="post" action="personaldetail/${username }">
					<input type="submit" name="personaldetail" value="Personal detail">
				</form>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<div>
		<table border="2" width="70%" cellpadding="2">  
		<h3><strong>Your Blogs</strong></h3><br>
			<tr><th>Blog name</th><th>Blog Creation Date</th><th>Content</th> <th> Username </th> <th> Details </th>
	   		<c:forEach var="blog" items="${list}" >   
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
	</div>
   <br/>  
   <div>
   	<form method="post" action="saveblog">
		<br>
		<table>
			<tr><td>Username: </td><td><input type="text" name="username" value=${username } readonly></h4></td></tr><br>
			<tr><td>Title: </td><td> <input type=text name="blog_title" placeholder="Blog Title" required></h4></td></tr><br>
		</table>
		Content: <br><textarea row="70" coloumn="100" name="blog_content" placeholder="Write"></textarea><br>
		<input type="submit" value="Post Blog">
	</form>
   </div>
	
</body>
</html>