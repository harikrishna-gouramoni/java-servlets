package com.employee.dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dashboard.servlet.bean.Employee;
import com.employee.dashboard.servlet.service.EmployeeService;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_JSP = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//employee is a parameter sending from different jsp page links
		String actionType = request.getParameter("action");
		
		EmployeeService service = new EmployeeService();
		
		if(actionType !=null && actionType.equalsIgnoreCase("ADDVIEW")) {
			//render page
			VIEW_JSP = "AddEmployee";
		}
		else if(actionType !=null && actionType.equalsIgnoreCase("SAVE")) {
			Employee emp  = getRequestData(request);
			System.out.println("Employee details from request: "+emp);
			
			boolean status = service.saveEmployee(emp);
			String message = "";
			
			if(status) {
				message ="Employee details saved successfull !!";
			}else {
				message ="Error occured while saving employee data ! Please contact system administrator !!";
			}
			
			request.setAttribute("response_message", message);
			//render page
			VIEW_JSP = "AddEmployee";
		}else if(actionType !=null && actionType.equalsIgnoreCase("VIEW")) {
			
			//call to service and get the data.
			List<Employee> empList = service.getAllEmployees();
			request.setAttribute("employeeList", empList);
			//render page
			VIEW_JSP = "ViewAllEmployeeDetails";
		}else if(actionType !=null && actionType.equalsIgnoreCase("EDIT")) {
			Employee emp  = getRequestData(request);
			
			request.setAttribute("employee", emp);
			VIEW_JSP = "EditEmployee";
		}else if(actionType !=null && actionType.equalsIgnoreCase("UPDATE")) {
			Employee emp  = getRequestData(request);
			System.out.println("Employee details from request: "+emp);
			
			boolean status = service.updateEmployee(emp);
			String message = "";
			
			if(status) {
				message ="Employee details updated successfull !!";
			}else {
				message ="Error occured while updating employee data ! Please contact system administrator !!";
			}
			
			request.setAttribute("response_message", message);
			//render page
			VIEW_JSP = "EditEmployee";
		}
		else if(actionType !=null && actionType.equalsIgnoreCase("DELETE")) {
			Employee emp  = getRequestData(request);
			System.out.println("Employee details from DELETE request: "+emp);
			
			boolean status = service.deleteEmployee(emp);
			String message = "";
			
			if(status) {
				message ="Employee details detelete successfull !!";
			}else {
				message ="Error occured while deteled employee data ! Please contact system administrator !!";
			}
			
			//GET UPDATED DATA FROM DB
			//call to service and get the latest data.
			List<Employee> empList = service.getAllEmployees();
			request.setAttribute("employeeList", empList);
			
			request.setAttribute("response_message", message);
			//render page
			VIEW_JSP = "ViewAllEmployeeDetails";
		}else {
			//
			VIEW_JSP = "index";
		}
		
		request.getRequestDispatcher(VIEW_JSP+".jsp").forward(request, response);
		
	}

	private Employee getRequestData(HttpServletRequest request) {
		Employee emp = new Employee();
			emp.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
			emp.setName(request.getParameter("name"));
			emp.setDob(request.getParameter("dob"));
			emp.setCity(request.getParameter("city"));
			emp.setContact_number(request.getParameter("contact_number"));
			
		return emp;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
