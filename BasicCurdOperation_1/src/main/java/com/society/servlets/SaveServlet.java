//SaveServlet.java
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


@WebServlet("/saveurl")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveServlet() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=response.getWriter();
		//set content type
		response.setContentType("text/html");
		//read the form data
		String Mname=request.getParameter("mname"); //here mname must match with name value in index.jsp
		String Address=request.getParameter("address"); //here address must match with name value in index.jsp
		String Membership=request.getParameter("membership"); //here membership must match with name value in index.jsp
		String ContactNo=request.getParameter("contactNo"); //here contactNo must match with name value in index.jsp
		String Email=request.getParameter("email"); //here emust match with name value in index.jsp
		//creating object
		Society s=new Society();
		//inserting form data into object
		s.setMname(Mname);
		s.setAddress(Address);
		s.setMembership(Membership);
		s.setContactNo(ContactNo);
		s.setEmail(Email);
		System.out.println("Society list:::"+s);
		//calling save method form dao class
		int status=SocietyDao.save(s);
		//getting status form above method
		if(status>0) {
			pw.println("Member saved successfully");
			request.getRequestDispatcher("index.jsp").include(request, response); 
		}
		else {
			pw.println("oops......!Problem in savaing Member");
		}
		pw.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
