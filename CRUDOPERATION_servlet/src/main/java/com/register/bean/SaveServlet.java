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
 * Servlet implementation class SaveServlet
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter pw=response.getWriter();  
        // String id=Integer.parseInt(request.getParameter("select register_seq.nextval from dual"));
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Emp e=new Emp(); 
     
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmpDao.save(e);  
        if(status>0){  
            pw.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
            pw.println("Sorry! unable to save record");  
        }  
          
        pw.close();  
    }  
  
}  