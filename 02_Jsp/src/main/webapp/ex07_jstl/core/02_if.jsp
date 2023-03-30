<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		<c:if></c:if>
		
		1. java if문을 대체하는 태그이다.
		2. else문이 지원되지 않는다. (if 문만 지원이 된다)
		3. 형식 
			<c:if test="조건식">
				실행문
			</c:if>
	 --%>

	<c:set var="age" value="24" scope="page"></c:set>
	<c:if test="${age le 100 }">
		<h1>살아있네~</h1>
	</c:if>
	<c:if test="${age gt 100 }">
		<h1>죽었네ㅠㅠ</h1>
	</c:if>

	<c:set var="score" value="84" scope="page"></c:set>
	<c:if test="${score ge 90 }">
		<h1>${score }점은 : A학점</h1>
	</c:if>
	<c:if test="${score ge 80 and score lt 90}">
		<h1>${score }점은 : B학점</h1>
	</c:if>
	<c:if test="${score ge 70 and score lt 80}">
		<h1>${score }점은 : C학점</h1>
	</c:if>
	<c:if test="${score ge 60 and score lt 70}">
		<h1>${score }점은 : D학점</h1>
	</c:if>
	<c:if test="${score ge 0 and score lt 60 }">
		<h1>${score }점은 : F학점</h1>
	</c:if>


















</body>
</html>