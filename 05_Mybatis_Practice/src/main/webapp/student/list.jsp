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

</head>
<body>

	<div>
		<h1>학생 관리</h1>
	</div>
	<input type="button" value="신규학생등록" id="btn_insert">
	<hr>
	<span>평균</span>
	<hr>
	<div>
		<table border="1">
			<caption>전체 학생 : <span id="student_count"></span>명</caption>
			<thead>
				<tr>
					<td>학번</td>
					<td>성명</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>평균</td>
					<td>학점</td>
					<td>버튼</td>
				</tr>
			</thead>
			<tbody id="member_list"></tbody>
		</table>
			<c:forEach var="student" items="${students}">
				
				
			
			</c:forEach>
	</div>
	
	
	<script>
		$('#btn_insert').on('click', function(ev){
			location.href = '${contextPath}/add.do';
		})
		
		
	</script>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>