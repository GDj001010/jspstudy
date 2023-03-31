package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import model.MyAgeService;
import model.MyBmiService;
import model.MyService;
import model.MyTodayService;

 
@WebServlet("*.do")	//. do로 끝나는 모든 요청

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 인코딩 (모든 서비스들이 인코딩 없이 곧바로 파라미터를 사용할 수 있도록) && 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// URLMapping 확인 (/today.do, /age.do 어떤 것으로 요청이 왔는지 확인하는 코드)
		String requestURI = request.getRequestURI();						/*/03_Mvc/today.do   */
		String contextPath = request.getContextPath();						/*/03_Mvc 			 */
		String urlMapping = requestURI.substring(contextPath.length());		/*/today.do			 */
		System.out.println(urlMapping);
		
		// Actionforward 객체 선언하기
		ActionForward actionforward = null;
		
		// MyService 인터페이스 타입의 myService 객체 선언하기
		MyService myService = null;
		
		// URLMapping에 따른 모델(서비스) 생성하기
		/*
		if(urlMapping.equals("/today.do")) {
			myService = new MyTodayService();
		} else if(urlMapping.equals("/age.do")) {
			myService = new MyAgeService();
		}
		*/
		
		// URLMapping에 따른 모델(서비스) 생성하기 - switch문
		switch(urlMapping) {
		case "/today.do":
			myService = new MyTodayService();
			break;
		case "/age.do":
			myService = new MyAgeService();
			break;
		case "/bmi.do":
			myService = new MyBmiService();
			break;
		}
		
		
		
		// 모델(서비스) 실행하기 null이 아닐 때만 실행 가능
		if(myService != null) {
			actionforward = myService.execute(request, response);
		}
		
		// 응답 View로 이동하기
		if(actionforward != null) {
			if(actionforward.isRedirect()) {
				response.sendRedirect(actionforward.getPath());
			} else {
				request.getRequestDispatcher(actionforward.getPath()).forward(request, response);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
