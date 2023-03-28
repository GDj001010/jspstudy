<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	request.setCharacterEncoding("UTF-8");
	Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
	String title = opt.orElse("환영합니다.");	// null 값이 온다면 "환영합니다." 가 타이틀로 나온다.
%>
<title><%=title %></title>
<%-- request.getContextPath() == /02_Jsp == jsp에선 jsp 주석만 사용한다. --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
<script src="<%=request.getContextPath()%>/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

	<nav>
		<ul>
			<li><a href="body1.jsp">body1</a></li>
			<li><a href="body2.jsp">body2</a></li>
			<li><a href="body3.jsp">body3</a></li>
		</ul>
	</nav>
	
	<hr>
	