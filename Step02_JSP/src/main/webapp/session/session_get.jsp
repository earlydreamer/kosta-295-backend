<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session 받기</h1>
	세션 정보 확인
	<br> 
	이름:<%=session.getAttribute("name")%><br> 
	취미:<%=session.getAttribute("hobbies")%><br>
	나이:<%=session.getAttribute("age")%><br>
	<br>
	페이지가 넘어가도 세션 정보가 저장되어 있다. getAttribute로 들고 있는 세션 정보를 가져올 수 있다.

</body>
</html>