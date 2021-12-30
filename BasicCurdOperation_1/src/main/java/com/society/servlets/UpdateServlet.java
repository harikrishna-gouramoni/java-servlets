package com.society.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.dao.SocietyDao;
import com.society.entity.Society;
@WebServlet("/updateurl")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();
		String sid=request.getParameter("mid");
		int mid=Integer.parseInt(sid);
		Society s1=SocietyDao.getMemberByMid(mid);
		String Mname=request.getParameter("mname");  
		String Address=request.getParameter("address");  
		String Membership=request.getParameter("membership");  
		String ContactNo=request.getParameter("contactNo");  
		String Email=request.getParameter("email");  
		Society s=new Society();  
		s.setMid(mid);  
		s.setMname(Mname); 
		s.setAddress(Address); 
		s.setMembership(Membership);  
		s.setContactNo(ContactNo);  
		s.setEmail(Email); 

		int status=SocietyDao.update(s);  
		if(status > 0){  
			response.sendRedirect("viewurl");  
		}else{  
			pw.println("Sorry! unable to update record");  
		}  

		pw.close();
	}
}
