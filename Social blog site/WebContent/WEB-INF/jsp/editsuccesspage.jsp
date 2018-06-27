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
	<h2><strong>Blogbook</strong></h2><br>
	<h3>Hello : </h3><h3>${username } </h3>
	<h3>${message }</h3>
	<a href="/editsuccesspage">Go back</a>
</body>
</html>