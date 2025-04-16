<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> result </h1>
	<!-- 페이지가 넘어가도  -->
	

	<h3>정보 출력</h3>
	id	: ${id} / ${sessionScope.id} / <c:out value="${id}" /><br>
	나이	: ${age}<br>				   <c:out value="${age}"/><br>
	주소	: ${addr}<br> / ${applicationScope.id } / <c:out value="${addr}"/><br><br>
	이름 : ${name}<br> 
	
	
</body>
</html>