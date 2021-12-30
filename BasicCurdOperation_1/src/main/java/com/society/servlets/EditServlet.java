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

@WebServlet("/editurl")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid=request.getParameter("mid");
		int mid=Integer.parseInt(sid);
		Society s1=SocietyDao.getMemberByMid(mid);
		//System.out.println("sobj ::"+s1);
		request.setAttribute("sobj", s1);
		request.getRequestDispatcher("member.jsp").include(request, response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
