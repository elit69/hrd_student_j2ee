package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnection;

public class StudentDAO {
	public StudentDAO(){}
	//Note: stu_status = -1 refer to all status
	//		There is no stu_status = -1 in Database
	//all class + all status	=>	stu_class LIKE %""%				OR stu_status = -1
	//any class + all status	=>	stu_class LIKE %"className"%	OR stu_status = -1
	//all class + any status	=>	stu_class LIKE %""%				AND stu_status = 0/1
	//any class + any status	=>	stu_class LIKE %"className"%	AND stu_status = 0/1
	public static ArrayList<StudentDTO> search(String name, String stu_class, int status) 
			throws ClassNotFoundException, SQLException{
		ResultSet rs=null;
		java.sql.Connection con = DBConnection.getConnection();
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
			ArrayList<StudentDTO> listStudent = new ArrayList<StudentDTO>();
			while(rs.next()){
				StudentDTO stu = new StudentDTO();
		    	stu = new StudentDTO();
		    	stu.setId(rs.getInt("stu_id"));
		    	stu.setName(rs.getString("stu_name"));
		    	stu.setGender(rs.getInt("stu_gender"));
		    	stu.setUniversity(rs.getString("stu_university"));
		    	stu.setStu_class(rs.getString("stu_class"));
		    	stu.setStatus(rs.getInt("stu_status"));      
			    listStudent.add(stu);
			}
	      return listStudent;
	    }finally{
	      if(rs!=null)try{rs.close();}catch(SQLException e){throw e;}
	      if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
	      if(con!=null)try{con.close();}catch(SQLException e){throw e;}
	    }
	}
}
