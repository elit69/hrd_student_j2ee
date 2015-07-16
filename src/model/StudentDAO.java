package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBConnection;

public class StudentDAO {
	private StudentDAO(){}
	//Note: stu_status = -1 refer to all status
	//		There is no stu_status = -1 in Database
	//all class + all status	=>	stu_class LIKE %""%				OR stu_status = -1
	//any class + all status	=>	stu_class LIKE %"className"%	OR stu_status = -1
	//all class + any status	=>	stu_class LIKE %""%				AND stu_status = 0/1
	//any class + any status	=>	stu_class LIKE %"className"%	AND stu_status = 0/1
	public static ArrayList<Student> search(String name, String stu_class, int status) 
			throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		Connection con = DBConnection.getConnection();
		String 	selectSQL = 
				status == -1 ? 
					"SELECT * FROM hrd_students "
					+ "WHERE stu_name LIKE \"%\"?\"%\" "
					+ "AND stu_class LIKE \"%\"?\"%\" "
					+ "OR stu_status = ?"
				:
					"SELECT * FROM hrd_students "
					+ "WHERE stu_name LIKE \"%\"?\"%\" "
					+ "AND stu_class LIKE \"%\"?\"%\" "
					+ "AND stu_status = ?"
				;
		PreparedStatement ps =  con.prepareStatement(selectSQL);
		ps.setString(1, name);
		ps.setString(2, stu_class);
		ps.setInt(3, status);
	    try{	    	
			rs = ps.executeQuery();		
			System.out.println(rs.getStatement().toString());
			ArrayList<Student> listStudent = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
		    	stu = new Student();
		    	stu.setStu_id(rs.getString("stu_id"));
		    	stu.setStu_name(rs.getString("stu_name"));
		    	stu.setStu_gender(rs.getInt("stu_gender"));
		    	stu.setStu_university(rs.getString("stu_university"));
		    	stu.setStu_class(rs.getString("stu_class"));
		    	stu.setStu_status(rs.getInt("stu_status"));      
			    listStudent.add(stu);
			}
	      return listStudent;
	    }finally{
	      if(rs!=null)try{rs.close();}catch(SQLException e){throw e;}
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }
	}
	public static boolean insert(Student stu) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps =  con.prepareStatement("INSERT INTO hrd_students VALUES(?,?,?,?,?,?)");
		ps.setString(1, stu.getStu_id());
		ps.setString(2, stu.getStu_name());
		ps.setInt(3, stu.getStu_gender());
		ps.setString(4, stu.getStu_university());
		ps.setString(5, stu.getStu_class());
		ps.setInt(6, stu.getStu_status());
	    try{	    	
			if(ps.executeUpdate()>0) return true;		
			System.out.println(ps.toString());
	    }catch(Exception e){
	    	return false;
	    }finally{
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }
	    return false;
	}
	public static void delete(String id) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps =  con.prepareStatement("DELETE FROM hrd_students WHERE stu_id = ?");
		ps.setString(1, id);
	    try{	    	
			ps.executeUpdate();		
			System.out.println(ps.toString());
	    }finally{
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }
	}
	public static void update(Student stu) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps =  con.prepareStatement(
				"UPDATE hrd_students " +
				"SET " +
					"stu_name = ?, " +
					"stu_gender = ?, " +
					"stu_university = ?, " +
					"stu_class = ?, " +
					"stu_status = ? " +
				"WHERE " +
					"stu_id = ?;");
		ps.setString(1, stu.getStu_name());
		ps.setInt(2, stu.getStu_gender());
		ps.setString(3, stu.getStu_university());
		ps.setString(4, stu.getStu_class());
		ps.setInt(5, stu.getStu_status());
		ps.setString(6, stu.getStu_id());
	    try{	    	
			ps.executeUpdate();		
			System.out.println(ps.toString());
	    }finally{
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }
	}
	public static String getLastID() throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		Connection con = DBConnection.getConnection();
		PreparedStatement ps =  con.prepareStatement("SELECT * FROM hrd_students ORDER BY stu_id DESC LIMIT 1");
	    try{	    	
	    	rs = ps.executeQuery();
	    	System.out.println(ps.toString());
	    	rs.next();
	    	return rs.getString(1);			
	    }finally{
	      if(rs!=null)try{rs.close();}catch(SQLException e){throw e;}
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }		
	}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Student s = new Student();
//		s.setStu_id("asdf");
//		s.setStu_name("3434343434343");
//		s.setStu_gender(3);
//		s.setStu_university("sdf");
//		s.setStu_class("sdf");
//		s.setStu_status(3);
//		update(s);
//		insert(s);
//		delete("asd");
//		System.out.println(getLastID());
//	}
}
