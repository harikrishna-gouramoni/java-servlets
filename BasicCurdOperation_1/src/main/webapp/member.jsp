<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red">Society membership form</h2>
<form action="updateurl" name="form" method="post">
<table>
<tr>
<td>Member Name::</td>
<td><input type="text"  value="${requestScope.sobj.mname}" name="mname"/></td>
</tr>
<tr>
<td>address::</td>
<td><input type="text" value="${requestScope.sobj.address}" name="address"/></td>
<tr>
<td>MemberShip::</td>
<td><input type="text" value="${requestScope.sobj.membership}" name="membership"/></td>
</tr>
<tr>
<td>ContactNo::</td>
<td><input type="number" value="${requestScope.sobj.contactNo}" name="contactNo"/></td>
</tr>
<tr>
<td>Email::</td>
<td><input type="email" value="${requestScope.sobj.email}" name="email"/></td>
</tr>
<tr>
<td><input type="hidden"  value="${requestScope.sobj.mid}" name="mid"/>
</td></tr>
<tr>
<td><input type="submit" value="Edit&Save"></td></tr>
<a href="viewurl">view Society members</a>   
  </form>
</body>
</html>