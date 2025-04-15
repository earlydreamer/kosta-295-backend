<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>http session 메소드 연습</h1>
	<h3>
		session.getId() =
		<%=session.getId()%><br> session.isNew() =
		<%=session.isNew()%><br> session.getMax() =
		<%=session.getMaxInactiveInterval()%><br>
		session.getCreationTime() =
		<%=session.getCreationTime()%><br> session.getLastAccessedTime()
		=
		<%=session.getLastAccessedTime()%><br>
	</h3>

	<%
	//Session에 정보 저장하기
	session.setAttribute("name","name");
	session.setAttribute("hobbies",new String[]{"취미1","취미2","취미3"});
	session.setAttribute("age","30");
	
	%>
	
	<br>
	<hr>
	
	세션 정보 확인<br>
	이름:<%=session.getAttribute("name") %><br>
	취미:<%=session.getAttribute("hobbies") %><br>
	나이:<%=session.getAttribute("age") %><br>
	
	<a href = "session_get.jsp">session 확인하러 가기</a>
	


</body>
</html>