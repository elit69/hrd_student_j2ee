package controller.student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDAO;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;

public class DeleteStudent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		String stu_name = request.getParameter("stu_name");
//		String stu_class = request.getParameter("stu_class");
//		int stu_status = Integer.parseInt(request.getParameter("stu_status"));
//		ArrayList<Student> listStudent = StudentDAO.search(stu_name, stu_class, stu_status);
//
//		String strListStudent = new Gson().toJson(listStudent);
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");				
//		response.getWriter().write(strListStudent);
//	
//		System.out.println(strListStudent);		
		return null;
	}

}
