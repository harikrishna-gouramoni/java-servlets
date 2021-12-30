package com.register.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.EmpDao;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
			throws ServletException, IOException {  
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		pw.println("<a href='index.jsp'>Add New Employee</a>");  
		pw.println("<h1>Employees List</h1>");  

		List<Emp> list=EmpDao.getAllEmployees();  

		pw.print("<table border='1' width='100%'>");  
		pw.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
		for(Emp e:list){  
			pw.print("<tr><td>"+e.getId()+"</td>"
					+ "<td>"+e.getName()+"</td>"
					+ "<td>"+e.getPassword()+"</td> "
					+ "<td>"+e.getEmail()+"</td>"
					+ "<td>"+e.getCountry()+"</td>"
					+ "<td><a href='edit?id="+e.getId()+"'>edit</a></td> "
					+ "<td><a href='delete?id="+e.getId()+"'>delete</a></td></tr>");
		}  
		pw.print("</table>");  

		pw.close();  
	}  
}  
