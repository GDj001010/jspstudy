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

	<!-- 동일한 폴더에 있기 때문에 파일명만 입력해줘도 된다. -->
	<div>
		<h1>쇼핑 목록</h1>
		<form action="02_add_to_cart.jsp">
			<select name="item">
				<option value="신라면">신라면</option>
				<option value="진라면">진라면</option>
				<option value="삼양라면">삼양라면</option>
			</select>
			<input type="number" name="item_count" min="1" max="10">개
			<button>장바구니에 추가</button>
			
		</form>
	</div>

</body>
</html>