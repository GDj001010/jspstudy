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

	<script>
		$(function){
			$('#btn_insert').on('click', function(ev){
				location.href = '${contextPath}/write.do';
			})
			
			$('#btn_find').on('click', function(ev){
				var begin = $('#begin').val();
				var eng = $('#eng').val();
				if(begin < 0 || begin == '' || begin > 100){
					alert('begin값을 확인하세요');
					return;
				} else if(end < 0 || end == '' || end > 100){
					alert('end값을 확인하세요');
					return;
				}
				location.href = '${contextPath}/find.do?begin=' + begin + '&end=' + end;
			})
		}
		
		
		
	</script>

	<div>
		<h1>학생 관리</h1>
	</div>
	<input type="button" value="신규학생등록" id="btn_insert">
	<hr>
	<div>
		<span>평균</span>
		<input type="number" name="begin" id="begin" placeholder="begin" min="0"  max="100">
		~
		<input type="number" name="end" id="end" placeholder="end" min="0" max="0">
		<input type="button" value="조회" id="btn_find">
		<input type="button" value="전체조회" id="btn_list">
		
	</div>
	<hr>
	<div>
		<table border="1">
			<caption>전체 학생 : ${count }명</caption>
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
			<tbody id="member_list">
			<c:if test="${count <= 0 }">
				<tr>
					<td colspan="8">등록된 학생이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${count != 0 }">
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.stuNo }</td>
						<td>${student.name }</td>
						<td>${student.kor }</td>
						<td>${student.eng }</td>
						<td>${student.math }</td>
						<td>${student.ave }</td>
						<td>${student.grade }</td>
						<td>
						<input type="button" value="상세" id="btn_detail">
						<input type="button" value="삭제" id="btn_delete">
						</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
			
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>