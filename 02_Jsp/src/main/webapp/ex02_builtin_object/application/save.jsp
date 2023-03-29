<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
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
		request.setCharacterEncoding("UTF-8");
	
		String createdDate = request.getParameter("created_date");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 작성자 ip 알아보기
		String ip = request.getRemoteAddr();
		
		// real path	  request.getServletContext() == ServletContext == application 이름의 객체
		String realPath = request.getServletContext().getRealPath("storage");
		// String realPath = application.getRealPath("storage");	// ServletContext 객체 == application 내장 객체
		
		// 디렉터리
		File dir = new File(realPath);
		
		if(dir.exists() == false){
			dir.mkdirs();
		}
		
		/*
			IPv4 : 127.0.0.1 		=> 127_0_0_1		구분자 바꿔주기
			IPv6 : 0:0:0:0:0:0:0:1  => 0_0_0_0_0_0_0_1
		*/
		
		
		// 저장할 파일명 : 작성IP_작성일.txt
		String fileName = ip.replace(".", "_").replace(":", "_") + "_" + createdDate.replace("-", "") + ".txt";
		// replaceAll 은 정규식으로 작성한다.
		// String fileName = ip.replaceAll("[.:]", "_") + "_" + createdDate.replace("-", "") + ".txt";
		
		// 파일 객체
		File file = new File(dir, fileName);
		
		// 문자 파일 출력 스트림 
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		// 파일 생성
		bw.write("작성일자 : " + createdDate);
		bw.newLine();
		bw.write("작성자 : " + writer);
		bw.newLine();
		bw.write("제목 : " + title);
		bw.newLine();
		bw.write("내용 : ");
		bw.newLine();
		bw.write(content);
		
		// 정리, 종료
		bw.flush();
		bw.close();
		
	%>	
	
	<script>
			
		var isCreated = <%=file.exists()%>; // var isCreated = false; var isCreated = true;
		if(isCreated){
			alert('<%=fileName%> 파일이 생성되었습니다.');
			location.href = '<%=request.getContextPath()%>/ex02_builtin_object/application/write_form.jsp';
		} else {
			alert('<%=fileName%> 파일이 생성되지 않았습니다.');
			history.back();
		}
		
	</script>










</body>
</html>