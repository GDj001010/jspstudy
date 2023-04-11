package service;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.StudentDAO;

public class StudentFindService implements IStudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		double begin = Double.parseDouble(request.getParameter("begin"));
		double end = Double.parseDouble(request.getParameter("end"));
		
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("begin", begin);
		map.put("end", end);
		
		StudentDAO dao = StudentDAO.getInstance();
		request.setAttribute("average", dao.getFindStudentAverage(map));
		request.setAttribute("students", dao.getAllCountStudent());
		request.setAttribute("count", dao.getAllCountStudent());
		
		
		return null;
	}

}
