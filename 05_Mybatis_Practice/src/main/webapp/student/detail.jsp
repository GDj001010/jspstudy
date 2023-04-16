<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath }/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	function fnList(){
		location.href = '${contextPath}/list.do';
	}
</script>
</head>
<body>
	
	<h1>학생 상세 조회</h1>
	<div>
		<form id="frm_detail" method="post" action="${contextPath}/modify.do">
			<div>
				<label for="stuNo">학번</label>
				<input value="${student.stuNo}" id="stuNo" name="stuNo" readonly>
			</div>
			<div>
				<label for="name">이름</label>
				<input value="${student.name}" id="name" name="name">
			</div>
			<div>
				<label for="kor">국어</label>
				<input value="${student.kor}" id="kor" name="kor">
			</div>
			<div>
				<label for="eng">영어</label>
				<input value="${student.eng}" id="eng" name="eng">
			</div>
			<div>
				<label for="math">수학</label>
				<input value="${student.math}" id="math" name="math">
			</div>
			<div>
				<label for="ave">평균</label>
				<input value="${student.ave}" id="ave" name="ave" readonly>
			</div>
			<div>
				<label for="grade">학점</label>
				<input value="${student.grade}" id="grade" name="grade" readonly>
			</div>
			<div>
				<button>수정하기</button>
				<input type="button" value="목록" onclick="fnList()">
			</div>
		</form>
	</div>
	
	
</body>
</html>