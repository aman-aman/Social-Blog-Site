<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Social Blogs Site
-----------------
1. Home page -- Links/buttons  for Login and Register. Below there will be some highlights about the blogging site.
2. Registration page - username , password, first name, last name, address, phone. Form validation will be there.
3. After successful registration user will get welcome message and there will be option to navigate back to home page.
4. Login page
5. After login user will be landed in My Blogs page where he will see all his blogs. If no blog is created then a message will be displayed that there is no blog and a link will be displayed to take the user to create blog page.
6. Create blog page - blog title, author, date, content. On submitting the blog data a blog record will be created in database with a primary key as combination of blog-title and current time stamp.
7. In the My Blogs page display the list of blogs created by the user with blog title and created date. The blog title will be a link and will take the user to blog details page.
8. Blog details page - Displays the blog title, author, date created, and content.
9. All blogs page - There will a link for all blogs in the site which will take the user to a page with all the list of blogs created by all users in the site. On clicking the blog title the blog details page will be opened.
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Blogbook</title>
</head>
<body >
			<div>
				<div>
					<h2><strong >Blogbook</strong></h2>
				</div>
					<form method="post" action="validate" >
						<table>
								<tr>    
	          						<td>Username : </td>   
	          						<td><input type="text" name="username" required></td>
	          						<td> </td>
	         					</tr>
	         					<tr>    
	          						<td>Password : </td>   
	          						<td><input type="password" name="password" required></td>
	         					</tr>
	         					<tr>
	         						<td>                                         </td>
	         						<td><input type="submit" value="LogIn" /></td>
	         					</tr>
						</table>
					</form>
				<div>
					<a href="retreivepassword">Forget Password?</a><br><br><!-- forgot password -->
					<a href="registration">Register Yourself</a><br><br><!-- register yourself -->
				</div>
			</div>
			<div>
				<section>
				  <h1><strong><strong>Blogbook</strong></strong></h1>
				  <p><strong><strong>Blogbook</strong></strong> is an Indian online Blogging and social networking service company .<br> 
					Its website was launched on February 4, 2004, by Aman Kumar Jha, along with fellow Harvard College students and roommates Eduardo Saverin, Andrew McCollum, Dustin Moskovitz, and Chris Hughes.<br>
					The founders initially limited the website's membership to Harvard students. <br>
					Later they expanded it to higher education institutions in the Boston area, the Ivy League schools, and Stanford University. <br>
					<strong>Blogbook</strong> gradually added support for students at various other universities, and eventually to high school students. <br>
					Since 2006, anyone who claims to be at least 13 years old has been allowed to become a registered user of <strong>Blogbook</strong>, though variations exist in this requirement, depending on local laws. <br>
					The name comes from the face book directories often given to Indian university students.<br>
					<strong>Blogbook</strong> held its initial public offering (IPO) in February 2012, and began selling stock to the public three months later,reaching an original peak market capitalization of $104 billion, a new record.<br>
					<strong>Blogbook</strong> makes most of its revenue from advertisements that appear onscreen.<br>
					<strong>Blogbook</strong> can be accessed from a large range of devices with Internet connectivity, such as desktop computers, laptops and tablet computers, and smartphones.<br>
					After registering, users can create a customized profile indicating their name, occupation, schools attended and so on. <br></p>
				</section>
			</div>
	</body>
</html>