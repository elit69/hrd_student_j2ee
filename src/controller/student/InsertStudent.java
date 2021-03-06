package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDAO;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;

public class InsertStudent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Student stu = new Student();
		stu.setStu_name(request.getParameter("stu_name"));
		stu.setStu_class(request.getParameter("stu_class"));
		stu.setStu_id(request.getParameter("stu_id"));
		stu.setStu_gender(Integer.parseInt(request.getParameter("stu_gender")));
		stu.setStu_status(Integer.parseInt(request.getParameter("stu_status")));
		stu.setStu_university(request.getParameter("stu_university"));

		String gson = new Gson().toJson(StudentDAO.insert(stu));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");				
		response.getWriter().write(gson);
	
		System.out.println(gson);		
		return null;
	}

}
