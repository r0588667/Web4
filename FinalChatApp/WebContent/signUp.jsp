<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" media="all" href="css/reset.css">
    <link rel="stylesheet" media="all" href="css/project.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up Page</title>
</head>
<body>
<form id="signUpForm" method="POST" action="ControllerServlet">
<p>ID</p>
<input type="text" name="id" value="">
<p>FirstName</p>
<input type="text" name="firstName" value="">
<p>LastName</p>
<input type="text" name="lastName" value="">
<p>Password</p>
<input type="text" name="password" value="">
<input type="hidden" name="action" value="SignUp">
<input type="submit" value="Submit">
</form>
</body>
</html>