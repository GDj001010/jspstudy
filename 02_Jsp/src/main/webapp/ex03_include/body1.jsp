<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%-- jsp 액션 태그 header.jsp로 보내줄 파라미터들을 태그로 작성한다. --%>
	<%-- 동적 incude : 포함되는 페이지에 파라미터를 전달할 수 있다. 파라미터 부분이 변하기 때문에 파라미터를 보내준다. (jsp 액션 태그) --%>
	<%-- 태그 내부에 주석처리가 되어있으면 실행이 안 될 수 있다. --%>
<jsp:include page="header.jsp">
	<jsp:param value="body1" name="title"/>
</jsp:include>	


	<h1>body1</h1>
	<script>
		$('h1').css('color', 'red');	// jquery 라이브러리의 동작 확인용
	</script>
	
<%-- 정적 include : 항상 같은 모습의 페이지를 포함한다. (include 지시어) --%>
<%@include file="footer.jsp" %>

	