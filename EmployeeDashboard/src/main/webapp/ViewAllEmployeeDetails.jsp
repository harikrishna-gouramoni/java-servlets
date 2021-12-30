<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@page import="com.employee.dashboard.servlet.bean.Employee" %>
<html>
<body>
<h2>Welcome to Employee Details</h2>

 <hr/>
 
 <a href="/EmployeeDashboard">Click here to back</a>
 
 ${requestScope.response_message }
 
 <h3>Employee details</h3>
 
 <table border="2">
 	<tr> 
 		<th> Employee ID </th>
 		<th> Name </th>
 		<th> DOB </th>
 		<th> City </th>
 		<th> Contact Number </th>
 		<th> Edit</th>
 		<th> Delete </th>
 	</tr>
 	
 	<c:forEach items="${requestScope.employeeList }" var="employee">
 	
 		<tr> 
 		<th><c:out value="${employee.employee_id }" /> </th>
 		<th><c:out value=" ${employee.name }" /> </th>
 		<th><c:out value=" ${employee.dob }" /> </th>
 		<th><c:out value=" ${employee.city }" /> </th>
 		<th><c:out value=" ${employee.contact_number }" /> </th>
 		
 		<th>
 			<img alt="Edit" src="images/edit.png" height="20" width="20"  
 				 onclick="editEmployee('${employee.employee_id }',
 										'${employee.name }',
 										'${employee.dob }',
 										 '${employee.city }',
 										 '${employee.contact_number }'
 										)"/>
 		</th>
 		<%-- <th> <input type="button" value="Edit" onclick="editEmployee('${employee.name }' )" />  </th> --%>
 		<th><a href='dashboard?action=DELETE&employee_id=<c:out value="${employee.employee_id }" />'> <c:out value="${employee.employee_id }" /> </a> </th>
 	</tr>
 	
 	</c:forEach>
 	
 </table>
 
 <form action="dashboard" method="post" name="editForm" >
 
 	<input type="hidden"  name="action" value="EDIT" />
 	<input type="hidden" id="employee_id" name=employee_id value="" />
 	<input type="hidden" id="name" name="name" value="" />
 	<input type="hidden" id="city" name="city" value="" />
 	<input type="hidden" id="dob" name="dob" value="" />
 	<input type="hidden" id="contact_number"  name="contact_number" value="" />
 
 </form>
 
</body>

<script type="text/javascript">
	function editEmployee(id, name, dob, city, contact)
	{
		document.getElementById("employee_id").value=id;
		document.getElementById("name").value=name;
		document.getElementById("city").value=city;
		document.getElementById("dob").value=dob;
		document.getElementById("contact_number").value=contact;
		
		document.editForm.submit();
	}

</script>

</html>
