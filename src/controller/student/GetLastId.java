package controller.student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDAO;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;

public class GetLastId implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				
		String gson = new Gson().toJson(StudentDAO.getLastID());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");				
		response.getWriter().write(gson);
	
		System.out.println(gson);		
		return null;
	}

}
