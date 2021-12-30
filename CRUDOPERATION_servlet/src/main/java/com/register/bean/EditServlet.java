package com.register.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.EmpDao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter pw=response.getWriter();  
        pw.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("mid");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
        //  pw.println("<a href='edit.jsp>");
        pw.print("<form action='edit2' method='post'>");  
        pw.print("<table>");  
        pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        pw.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/>  </td></tr>");  
        pw.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        pw.print("<tr><td>Country:</td><td>");  
        pw.print("<select name='country' style='width:150px'>");  
        pw.print("<option>India</option>");  
        pw.print("<option>USA</option>");  
        pw.print("<option>UK</option>");  
        pw.print("<option>Other</option>");  
        pw.print("</select>");  
        pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        pw.print("</td></tr>");  
        pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        pw.print("</table>");  
        pw.print("</form>");  
          
        pw.close();  
    }  
}  