<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// session == 브라우저 닫히기 전까지 저장, 유니크한 아이디를 브라우저 열 때마다 준다.
		String sessionId = session.getId();
	%>
	<h1><%=sessionId %></h1>

</body>
</html>