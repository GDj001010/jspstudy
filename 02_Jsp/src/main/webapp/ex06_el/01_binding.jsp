<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		Jsp의 binding (속성을 저장할 수 있는 영역)
		1. pageContext	: this,				  현재 Jsp 페이지에서 접근할 수 있다. (스코프)
		2. request		: HttpServletRequest, 하나의 요청에서 접근할 수 있다. (1회용)
		3. session		: HttpSession, 		  브라우저 종료까지 접근할 수 있다.
		4. application	: ServletContext,	  애플리케이션 종료까지(서버종료)접근할 수 있다.
	 --%>
	 
	 <%--
	 	EL로 표현할 때 우선 순위
	 	Jsp binding 우선 순위
	 	1. 같은 이름의 속성이 서로 다른 영역에 저장될 수 있다.
	 	2. 접근 범위(스코프)가 좁을 수록 높은 우선 순위를 가진다.
	 		높음										  낮음
	 		pageContext -> request -> session -> applicationn
	 	3. 각 영역을 지정하는 EL(표현언어) 내장 객체가 있다.
	 			영역				:	내장 객체
	 		1) pageContext 영역에선 : pageScope 객체를 사용
	 		2) request 영역에선		: requestScope 객체를 사용
	 		3) session 영역에선		: sessionScope 객체를 사용
	 		4) application 영역에선	: applicationScope 객체를 사용
	 	4. Jsp binding 영역에 저장된 값은 모두 EL로 표현할 수 있다.
	  --%>

	<%
		pageContext.setAttribute("a", 1);
		request.setAttribute("a", 10);
		session.setAttribute("a", 100);
		application.setAttribute("a", 1000);
	%>
	<%-- 표현식 --%>
	<h1><%=pageContext.getAttribute("a") %></h1>
	<h1><%=request.getAttribute("a") %></h1>
	<h1><%=session.getAttribute("a") %></h1>
	<h1><%=application.getAttribute("a") %></h1>

























</body>
</html>