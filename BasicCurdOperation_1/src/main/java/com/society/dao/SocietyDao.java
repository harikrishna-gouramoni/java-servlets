package com.society.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.society.entity.Society;


public class SocietyDao {
	private static final String Query="INSERT INTO SOCIETY (MID,MNAME,ADDRESS,MEMBERSHIP,CONTACTNO,EMAIL) VALUES(?,?,?,?,?,?)";
	private static final String Get_Sequence_Val="select register_seq.nextval as seq_val from dual";
	private static final String GetAllMembers="select * from  Society";
	private static final String GetMemberByMid="select * from Society where mid=?";
	private static final String Update="update Society set mname=?,address=?,membership=?,contactNo=?,email=? where mid=?";
	private static final String Delete="delete from Society  where mid=?";

	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}catch (Exception e) {
			e.printStackTrace();		}
		return con;
	}

	public static int save(Society s) {
		int status=0;
		try {
			//get connection object
			Connection con = getConnection();
			//get preparedstatement
			PreparedStatement ps=con.prepareStatement(Query);
			System.out.println("Query:::::"+Query);
			//set the object values

			ps.setInt(1,getSequenceval());
			ps.setString(2, s.getMname());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getMembership());
			ps.setString(5, s.getContactNo());
			ps.setString(6, s.getEmail());
			System.out.println("preparedStatement:::"+ps);
			//resultset
			status=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int  getSequenceval() {
		ResultSet rs;
		String sequence_val=null;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(Get_Sequence_Val);
			rs=ps.executeQuery();
			while(rs.next()) {
				sequence_val = rs.getString("seq_val");
			}
		}catch(Exception e) {e.printStackTrace();}

		return Integer.parseInt(sequence_val);
	}

	public static List<Society> getAllMembers() {
		List<Society> list=new ArrayList<Society>();
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(GetAllMembers);
			System.out.println("ps"+ps);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Society s=new Society();
				s.setMid(rs.getInt(1));
				s.setMname(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setMembership(rs.getString(4));
				s.setContactNo(rs.getString(5));
				s.setEmail(rs.getString(6));
				list.add(s);
				System.out.println("list"+list);
			}
			con.close();
		}catch (Exception e) { e.printStackTrace();}

		return list;
	}

	public static Society getMemberByMid(int mid) {
		Society s=new Society();
		try {
			Connection con=SocietyDao.getConnection();
			PreparedStatement ps=con.prepareStatement(GetMemberByMid);
			//System.out.println("ps form get member id method"+ps);
			ps.setInt(1, mid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s.setMid(rs.getInt(1));
				s.setMname(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setMembership(rs.getString(4));
				s.setContactNo(rs.getString(5));
				s.setEmail(rs.getString(6));

				System.out.println("result set"+rs);
			}	//if	
		}//try
		catch (Exception ex) {
			ex.printStackTrace();	

		}//catch
		return s;
	}//getby id method

	public static int update(Society s) { 
		int status=0;  
		try{  
			//getting connection from get connection method
			Connection con=SocietyDao.getConnection();  
			PreparedStatement ps=con.prepareStatement(Update);  
			System.out.println("query from update()::"+ps);
			ps.setString(1, s.getMname());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getMembership());
			ps.setInt(4, Integer.parseInt(s.getContactNo()));
			ps.setString(5, s.getEmail()); 
			ps.setInt(6, s.getMid());

			System.out.println("society object"+s);
			
			status=ps.executeUpdate();  
			// System.out.println("status form update method"+status);

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}

	public static int delete(int mid) {
		int status=0;  
		try{  
			Connection con=SocietyDao.getConnection();  
			PreparedStatement ps=con.prepareStatement(Delete);  
			System.out.println("query from update()::"+ps);
			ps.setInt(1,mid);
			status=ps.executeUpdate();  
			System.out.println("ps from delete mehtod"+ps);
			con.close();  
		}catch(Exception ex){
			ex.printStackTrace();
		}  
		return status;  
	}
}  

