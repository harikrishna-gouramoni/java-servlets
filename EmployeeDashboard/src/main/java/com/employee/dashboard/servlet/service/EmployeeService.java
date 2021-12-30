package com.employee.dashboard.servlet.service;

import java.util.List;

import com.employee.dashboard.servlet.bean.Employee;
import com.employee.dashboard.servlet.dao.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO dao = new EmployeeDAO();

	public List<Employee> getAllEmployees() {

		List<Employee> empList = dao.getAllEmployees();

		return empList;
	}

	public boolean saveEmployee(Employee employee) {
		boolean saveStatus = false;
		int cnt = dao.saveEmployee(employee);

		if (cnt > 0) {
			saveStatus = true;
		}
		return saveStatus;

	}

	public boolean updateEmployee(Employee employee) {
		boolean saveStatus = false;
		int cnt = dao.updateEmployee(employee);

		if (cnt > 0) {
			saveStatus = true;
		}
		return saveStatus;

	}

	public boolean deleteEmployee(Employee employee) {
		boolean saveStatus = false;
		int cnt = dao.deleteEmployee(employee);

		if (cnt > 0) {
			saveStatus = true;
		}
		return saveStatus;

	}

}
