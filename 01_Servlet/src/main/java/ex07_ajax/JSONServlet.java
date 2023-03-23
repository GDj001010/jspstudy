package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/JSONServlet")

/*
	Dynamic Web Project에서 외부 라이브러리(*.jar)를 사용하는 방법
	
	방법1. CATALINA_HOME\lib 디렉터리에 사용할 라이브러리를 추가한다.
	방법2. 컨텍스트(프로젝트)에 사용할 라이브러리를 추가한다.	( 수업에서 사용할 방법 )
		src/main/webapp/WEB-INF/lib 디렉터리에 사용할 라이브러리를 추가한다.
*/
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JSONServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 요청 인코딩
			request.setCharacterEncoding("UTF-8");
			
			// 요청 파라미터
			String name = request.getParameter("name");
			String strAge = request.getParameter("age");
			
			int age = 0;
			if(strAge != null && strAge.isEmpty() == false) {
				age = Integer.parseInt(strAge);
			};
			// 나이 예외 처리
			if(age < 0 || age > 100) {
				throw new AgeHandleException(age + "살은 잘못된 나이입니다", 600);
			}
			// 이름 예외 처리
			if(name.length() > 6 || name.length() < 2) {
				throw new NameHandleException(name + "은 잘못된 이름입니다.", 601);
			}
			
			
			// 응답할 JSON 데이터
			
			JSONObject obj = new JSONObject();
			obj.put("name", name);	// JSON 객체에 저장하는 방법 ( put )
			obj.put("age", age);
			
			// System.out.println(obj.toString());  // {"name": "마돈나", "age": 50}
			
			// 응답 데이터 타입
			response.setContentType("application/json; charset=UTF-8");
			
			// 출력 스트림 생성
			PrintWriter out = response.getWriter();
			
			// 출력
			String resData = obj.toString();	// 텍스트 형식으로 바꿔 보내줘야 된다. (나중에 추가작업시 라이브러리 특성상 충돌이 날 수 있음)
			out.println(resData);	// 텍스트 형식으로 된 JSON 데이터를 응답한다, JSON 객체가 들어온다, JSON.parse(resData)를 해줄 필요가 없다.
			out.flush();
			out.close();
		  } catch(MyHandleException e) {	// e.getErrorCode(), e.getmessage() 사용 가능
			 
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(e.getErrorCode());
			
			response.getWriter().println(e.getMessage());	// 보낼 내용이 적을 땐 PrintWriter out = response.getWriter(); 생략하고 한 번에 처리한다.
			
		  }
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




















