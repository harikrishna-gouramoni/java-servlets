package com.aadhaar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aadhaar.bean.Customer;
import com.aadhaar.service.SearchService;

/**
 * Servlet implementation class SearchAdharServlet
 */
@WebServlet("/searchUrl")
public class SearchAdharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SearchAdharServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /*
     * Method to lunch page
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//call service and get the data
		String aadharNumber = request.getParameter("aadhar");
		
		Customer aadharCustomer = SearchService.getAadharSerachResult(aadharNumber);
		request.setAttribute("myAadhar", aadharCustomer);
		//forward to jsp
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		//response.getWriter().append("Requested Aadhar number to search  ").append(aadharNumber);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
