<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> if and choose </h1>

<!--  http://localhost:8080/Step02_JSP/el_jstl/ex03_if_choose.jsp?age=10
param에 age가 있다면 당신은 n살입니다 -->

<c:if test="${not empty param.age}">
<h3>당신은 ${param.age}살입니다.</c:if></h3>

<!-- http://localhost:8080/Step02_JSP/el_jstl/ex03_if_choose.jsp?age=20
param의 age가 18 이상이면 "많은 이용 부탁드립니다" --color blue , 아니면 "18세 미만입니다."-- color red  -->

<c:if test="${not empty param.age}">
	<c:choose>
		<c:when test="${param.age>=18}"><h3 style=color:blue>18세 이상입니다. 많은 이용 부탁드립니다.</style></c:when>
		<c:otherwise><h3 style=color:red>18세 미만입니다.</style></c:otherwise>
	</c:choose>
</c:if>

</body>
</html>