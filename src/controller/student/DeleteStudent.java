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
		
		String stu_id = request.getParameter("stu_id");
		StudentDAO.delete(stu_id);

		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");				
		
	
		System.out.println(stu_id);		
		return null;
	}

}
