<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formsCss.css">
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h2>Update form</h2>
<h2>Update User</h2>

<% 
if(request.getAttribute("updateMsg")!=null){
	out.println(request.getAttribute("updateMsg"));
	
}%>
<div class="container">
  <form action="updateController" method="post">
  

  
    <label for="emailid">email Id</label>
    <input type="text" id="lname" name="emailid" value="<%=request.getAttribute("emialid") %>"readonly>
    
    <label for="City">City</label>
    <input type="text" id="lname" name="city" value="<%=request.getAttribute("city") %>">


    
    <input type="submit" value="Update">
     
  </form>
</div>
</body>
</html>