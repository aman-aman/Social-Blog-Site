<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <h1><strong>Blogbook</strong></h1>
 <h1>Edit User</h1>  
<div>
	<!-- username , password, first name, last name, address, phone -->
		
		<h3>After editing your data you will be logged out from the system!!!</h3>
		
		<form:form method="post" action="editsaveuser/${username }" >
				<table>
					<tr>
						<td>Enter user details....</td>
					</tr>
					<tr>    
          				<td>Firstname : </td>   
          				<td><form:input path="firstname"/></td> 
         			</tr>
         			<tr>    
          				<td>Lastname : </td>   
          				<td><form:input path="lastname"/></td> 
         			</tr>
         			<tr>    
          				<td>Address: </td>   
          				<td><form:input path="address"/></td>  
         			</tr>
         			<tr>    
          				<td>Phone: </td>   
          				<td><form:input path="phone"  /></td>  
         			</tr>
         			<tr>    
          				<td>Password : </td>   
          				<td><form:input path="password"  type="password" /></td>  
         			</tr> 
					<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</div>