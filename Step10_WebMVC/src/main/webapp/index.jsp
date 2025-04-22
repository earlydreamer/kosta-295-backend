<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Web MVC Refactor Test</h1>
	<!--  어떤 요청이던 /front로 모은다 -->
	<a href = "${pageContext.request.contextPath}/front?key=select">검색</a>
	<a href = "${pageContext.request.contextPath}/front?key=update">수정</a>
	<a href = "${pageContext.request.contextPath}/front?key=delete">삭제</a>
	<a href = "${pageContext.request.contextPath}/front?key=insert">등록</a>
	
	
	
	
	
	
</body>
</html>