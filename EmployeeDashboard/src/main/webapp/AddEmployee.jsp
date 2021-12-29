<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
<%! String response_message = ""; %>
 <%  response_message = (String) request.getAttribute("response_message"); %>
 
<h2>Employee registration details</h2>

<h3> <%=response_message %></h3>

<form action="dashboard" method="post">

	<input type="hidden" name="action" value="SAVE" />
	
	<table>
		<tr>
			<td>Name :</td>
			 <td><input type="text" name="name"  /> </td>
		</tr>
		<tr> 
			<td>DOB :</td> 
			 <td> <input type="text" name="dob"  /> </td>
		</tr>
		<tr>
			<td>City :</td> 
			<td><input type="text" name="city"  /> </td>
		</tr>
		<tr> 
			<td>Contact # :</td> 
			 <td> <input type="text" name="contact_number"  /> </td>
		</tr>
	</table>
	
	<input type="submit" name="submit" value="Save Employee" />
</form>

<hr>

<a href="/EmployeeDashboard">Click here to back</a>
</body>
</html>