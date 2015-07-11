package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBConnection;


public class StudentDAO {
	public StudentDAO(){}
	public static ArrayList<StudentDTO> search(String name, String u, boolean status) 
			throws ClassNotFoundException, SQLException{
		java.sql.Connection con =   DBConnection.getConnection();
//		PreparedStatement ps = con.prepareStatement
//				("SELECT * FROM hrd_students WHERE stu_name LIKE \"%?%\" "
//						+ "AND stu_university LIKE \"%?%\" "
//						+ "AND stu_status = ?");
		
		PreparedStatement ps =  con.prepareStatement("select * from hrd_students where"
				+ "stu_name = '?'");
		ps.setString(1,name);
//		ps.setString(2, u);
//		ps.setInt(3, 1);
		ResultSet rs = ps.executeQuery();		
		ArrayList<StudentDTO> lstStudent = new ArrayList<StudentDTO>();
	    try{
			while(rs.next()){
				StudentDTO stu = null;
		    	stu = new StudentDTO();
		    	stu.setId(rs.getInt("stu_id"));
		    	stu.setName(rs.getString("stu_name"));
		    	stu.setGender(rs.getBoolean("stu_gender"));
		    	stu.setUniversity(rs.getString("stu_university"));
		    	stu.setStu_class(rs.getString("stu_class"));
		    	stu.setStatus(rs.getBoolean("stu_status"));      
			    lstStudent.add(stu);
			}
	      return lstStudent;
	    }finally{
	      if(rs!=null)try{rs.close();}catch(SQLException e){throw e;}
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }
	}
}
