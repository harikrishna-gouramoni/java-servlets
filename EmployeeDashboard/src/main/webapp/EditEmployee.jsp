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

${requestScope.response_message }

<form action="dashboard" method="post">

	<input type="hidden" name="action" value="UPDATE" />
	
	<input type="hidden" name="employee_id" value="${requestScope.employee.employee_id }" />
	
	<table>
		<tr>
			<td>Name :</td>
			 <td><input type="text" name="name" value="${requestScope.employee.name }" /> </td>
		</tr>
		<tr> 
			<td>DOB :</td> 
			 <td> <input type="text" name="dob"  value="${requestScope.employee.dob }" /> </td>
		</tr>
		<tr>
			<td>City :</td> 
			<td><input type="text" name="city" value="${requestScope.employee.city }"  /> </td>
		</tr>
		<tr> 
			<td>Contact # :</td> 
			 <td> <input type="text" name="contact_number" value="${requestScope.employee.contact_number }" /> </td>
		</tr>
	</table>
	
	<input type="submit" name="submit" value="Save Employee" />
</form>

<hr>

<a href="/EmployeeDashboard">Click here to back</a>
</body>
</html>