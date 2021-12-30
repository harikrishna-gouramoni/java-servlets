<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Society membership form</title>
</head>
<body>
<h2 style="color:red">Society membership form</h2>
<form action="saveurl" name="form" method="post">
<table>
<tr>
<td>Member Name::</td>
<td><input type="text" placeholder="enter member name" name="mname"/></td>
</tr>
<tr>
<td>address::</td>
<td><input type="text" placeholder="enter member address" name="address"/></td>
<tr>
<td>MemberShip::</td>
<td><input type="text" placeholder="enter membership" name="membership"/></td>
</tr>
<tr>
<td>ContactNo::</td>
<td><input type="number" placeholder="enter contact number" name="contactNo"/></td>
</tr>
<tr>
<td>Email::</td>
<td><input type="email" placeholder="enter Email Id" name="email"/></td>
</tr>
<tr>
<td><input type="submit" value="save"/></td>
</tr>
</table>
<br/>  
<a href="viewurl">view Society members</a>  
</form></body>
</html>
