<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formsCss.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Login Form</h3>
<p style="color:red;">
 <%
 if(request.getAttribute("errormsg")!=null){
	 out.println(request.getAttribute("errormsg"));
 }
 %>
</p>

<div class="container">
  <form action="loginController" method="post">
    <label for="emailid">Email Id</label>
    <input type="text" id="emailid" name="emailid" >

    <label for="password">Password</label>
    <input type="password" id="pwd" name="password">


    <input type="submit" value="Login">
  </form>
</div>


</body>
</html>