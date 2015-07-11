package controller;

import java.sql.SQLException;
import model.StudentDAO;
import model.StudentDTO;

public class StudentController {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		for(StudentDTO stu : StudentDAO.search("a", "", false)){
			System.out.println(stu.getName());
		}
	}
}
