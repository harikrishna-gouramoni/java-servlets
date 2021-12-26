<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.aadhaar.bean.Customer" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aadhaar Home</title>
</head>


<body>

	<h2 align="center">Welcome to Aadhaar Portal </h2>
	<form name="aadharForm" method="get" action="searchUrl">
		Search Aadhaar Number : <input type="text" name="aadhar">
			<input type="submit" name="adharSubmit" value="SEARCH" />
	</form>
	
	<br />
	<hr />
	<h3> You are Aadhaar details from Portal</h3>
	<hr />
<table border="2">
	<tr>
		<th>Aadhaar Number </th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gender</th>
		<th>Date of Birth</th>
	</tr>
	<tr>
		<th> <c:out value="${requestScope.myAadhar.aadharNumber}" /> </th>
		<th>  <c:out value="${requestScope.myAadhar.firstName}" /> </th>
		<th> <c:out value="${requestScope.myAadhar.lastName}" /> </th>
		<th> <c:out value="${requestScope.myAadhar.gender}" /> </th>
		<th> <c:out value="${requestScope.myAadhar.dob}" /> </th>
	</tr>
</table>
	
</body>
</html>