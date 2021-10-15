<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formsCss.css">
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h3>New Registration Form</h3>
<h1>New Registration Form</h1>
 <%
    if(request.getAttribute("msg")!=null){
    	out.println(request.getAttribute("msg"));
    	
    }
    
    
    %>
<div class="container">
  <form action="userRegistrationController" method="post">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" >

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname">
    
    <label for="emailid">email Id</label>
    <input type="text" id="lname" name="emailid">
    
    <label for="City">City</label>
    <input type="text" id="lname" name="City">

    <label for="country">Country</label>
    <input type="text" name="country">
    

    

    <input type="submit" value="Submit">
   
    
    
    
  </form>
</div>
</body>
</html>