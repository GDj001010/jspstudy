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
</head>
<body>

	<script>
		$(function(){
			$('btn_list').on('click', function(ev){
				location.href = '${contextPath}/list.do';
			})
			
			$('#frm_write').on('submit', function(ev){
				var kor = $('#for');
				var eng = $('#eng');
				var math = $('#math');
				if(kor.val() == '' || kor.val() < 0 || kor.val() > 100) {
					alert('국어 점수를 확인하세요');
					kor.focus;
					ev.preventDefault();
					return;
				} else if (eng.val() == '' || eng.val() < 0 || eng.val() > 100){
					alert('영어 점수를 확인하세요');
					eng.focus;
					ev.preventDefault();
					return;
				} else if (math.val() == '' || math.val() < 0 || math.val() > 100){
					alert('수학 점수를 확인하세요');
					math.focus;
					ev.preventDefault();
					return;
				}
			})
		})
	</script>
	
	<div>
		<h1>신규학생등록 화면</h1>
	</div>
	<div>
		<form id="frm_write" method="post" action="${contextPath }/add.do">
			<div>
				<label for="name">이름</label>
				<input name="name" id="name" type="text">
			</div>
			<div>
				<label for="kor">국어</label>
				<input type="text" name="kor" id="kor">
			</div>			
			<div>
				<label for="eng">영어</label>
				<input type="text" name="eng" id="eng">
			</div>			
			<div>
				<label for="math">수학</label>
				<input type="text" name="math" id="math">
			</div>
			<hr>
			<div>
				<button>작성완료</button>
				<input type="reset" value="다시작성">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
	
</body>
</html>