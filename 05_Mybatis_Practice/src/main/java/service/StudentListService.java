package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.StudentDAO;

public class StudentListService implements IStudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StudentDAO dao = StudentDAO.getInstance();
		request.setAttribute("students", dao.selectAllStudentList());
		request.setAttribute("count", dao.getAllCountStudent());
		
		return new ActionForward("student/list.jsp", false);
	}

}
