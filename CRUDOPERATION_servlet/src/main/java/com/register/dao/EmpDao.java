package com.register.dao;

import java.util.*;

import com.register.bean.Emp;

import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user_register(name,password,email,country,id) values (?,?,?,?,?)");  
           
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,getNextSequenceValue());  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user_register set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user_register where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user_register where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setName(rs.getString(1));  
                e.setPassword(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setCountry(rs.getString(4)); 
                e.setId(rs.getInt(5)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user_register");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setName(rs.getString(1));  
                e.setPassword(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setCountry(rs.getString(4));  
                e.setId(rs.getInt(5));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    public static int getNextSequenceValue() {
		ResultSet rs;
		String sequece_value = null;
		try {
			//calling the data base connection method
			Connection con=getConnection();
			//creating prepared statement
			PreparedStatement ps=con.prepareStatement("select register_seq.nextval as seq_value from dual");
			//execute the query
			rs=ps.executeQuery();
			while(rs.next()) {
				sequece_value = rs.getString("seq_value");
			}
		}
		catch (Exception e) {
		}
		return Integer.parseInt(sequece_value);
	}
}  