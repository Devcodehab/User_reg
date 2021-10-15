<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/table.css">
<meta charset="ISO-8859-1">
<title>Show Registration</title>
</head>
<body>
	<h2>User Registration details</h2>
<table  id="customers">
	<tr>
	<th>First name</th>
	<th>Last name</th>
	<th>email Id</th>
	<th>city</th>
	<th>Country</th>
	<th>Delete</th>
	<th>Update</th>
	</tr>
	<%
		ResultSet results=(ResultSet)request.getAttribute("results");
		while(results.next()){%>
			<tr>
			<td><% out.println(results.getString(1));%></td>
			<td><% out.println(results.getString(2));%> </td> 
			<td><% out.println(results.getString(3));%> </td>
			<td><% out.println(results.getString(4));%> </td>
			<td><% out.println(results.getString(5));%> </td>
			<td><a href="deleteController?emailid=<%=results.getString(3)%>">Delete</a> </td>
			<td><a href="updateController?emailid=<%=results.getString(3)%>&city=<%=results.getString(4)%>">Update</a> </td>
			</tr>
	<%	}%>
	</table>
</body>
</html>