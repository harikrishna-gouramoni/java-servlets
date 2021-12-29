package com.employee.dashboard.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.dashboard.connection.MySQLConnection;
import com.employee.dashboard.servlet.bean.Employee;

public class EmployeeDAO {

	private static final String INSERT_SQL = "INSERT INTO EMPLOYEE(NAME, DOB, CITY, CONTACT_NUMBER) VALUES (?,?,?,?)";
	private static final String GET_ALL_EMPLOYEES_SQL = "SELECT EMPLOYEE_ID, NAME, DOB, CITY, CONTACT_NUMBER from EMPLOYEE ";
	private static final String UPDATE_SQL = "UPDATE EMPLOYEE SET NAME=?, DOB=?, CITY=?, CONTACT_NUMBER=? WHERE  EMPLOYEE_ID=?";
	private static final String DELETE_SQL = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID=? ";
	
	public int saveEmployee(Employee employee) {
		Connection con = MySQLConnection.getConnection();
		//System.out.println("Mysql connection ::"+con);
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
				ps.setString(1, employee.getName());
				ps.setString(2, employee.getDob());
				ps.setString(3, employee.getCity());
				ps.setString(4, employee.getContact_number());
				
				System.out.println("Executing final query - "+INSERT_SQL);
				System.out.println("Employee data before inserting into table - "+employee);
			 status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return status;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee> ();
		Connection con = MySQLConnection.getConnection();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(GET_ALL_EMPLOYEES_SQL);
			ResultSet rs = ps.executeQuery();
			
			
			//parsing results
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				emp.setName(rs.getString("NAME"));
				emp.setDob(rs.getString("DOB"));
				emp.setCity(rs.getString("CITY"));
				emp.setContact_number(rs.getString("CONTACT_NUMBER"));
				
				empList.add(emp);
			}
			
			System.out.println("List of employees from DAO - "+empList);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return empList;
	}

	public int updateEmployee(Employee employee) {
		Connection con = MySQLConnection.getConnection();
		//System.out.println("Mysql connection ::"+con);
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
				ps.setString(1, employee.getName());
				ps.setString(2, employee.getDob());
				ps.setString(3, employee.getCity());
				ps.setString(4, employee.getContact_number());
				ps.setInt(5, employee.getEmployee_id());
				
				System.out.println("Executing final UPDATE query - "+UPDATE_SQL);
				System.out.println("Employee data before UPDATING into table - "+employee);
			 status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return status;
	}

	public int deleteEmployee(Employee employee) {
		Connection con = MySQLConnection.getConnection();
		//System.out.println("Mysql connection ::"+con);
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_SQL);
				ps.setInt(1, employee.getEmployee_id());
				
				
				System.out.println("Executing final DELETE_SQL query - "+DELETE_SQL);
				System.out.println("Employee data before DELETE_SQL into table - "+employee);
			 status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return status;
	}

}
