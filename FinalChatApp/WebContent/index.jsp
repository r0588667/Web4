<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
    <head>
        <link rel="stylesheet" media="all" href="css/reset.css">
        <link rel="stylesheet" media="all" href="css/project.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
	<div id="login-box">

            
		<h2>Login</h2>

		<form name='loginForm' action="ControllerServlet" method='POST'>

		  <table>
			<tr>
				<td>User:</td>
				<td><input id='id' type='text' name='id' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input id='password' type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input id='submitbutton' name="submit" type="submit"
					value="Login" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="action" value="Login">

		</form>
	</div>
	<a href="ControllerServlet?action=ToDiscussion">Discussions</a>
    </body>
</html>