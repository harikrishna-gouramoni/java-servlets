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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/edit2")
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter pw=response.getWriter();  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid); 
          
        Emp e=new Emp();  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
        e.setId(id); 
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("view");  
        }else{  
            pw.println("Sorry! unable to update record");  
        }  
          
        pw.close();  
    }  
  
}  