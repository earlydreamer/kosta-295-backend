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
	<h1> out_set </h1>
	<h3> &lt;c:out> and &lt;c:set> </h3>

<%--
	String name = "name";
	request.setAttribute("name",name);
--%>

	<c:set var="id" value="test" scope="session"/> <!--  session.setAttribute("id","test")-->
	<c:set var="age" value="33"/> <!--  session.setAttribute("id","test")-->
	<c:set var="addr" value="주소" scope="application"/> <!--  session.setAttribute("id","test")-->

<h3>정보 출력</h3>
	id	: ${id} / ${sessionScope.id} / <c:out value="${id}" /><br>
	나이	: ${age}<br>				   <c:out value="${age}"/><br>
	주소	: ${addr}<br> / ${applicationScope.addr } / <c:out value="${addr}"/><br><br>
	이름 : ${name}<br> <!-- 없는 변수를 읽으려고 해도 터지지 않고 빈 문자열을 찍는다 --> 

<hr>

<c:out value = "<h3>escapeXml TRUE</h3>" escapeXml = "true"/> <!--  XSS 방지를 위한 안전 동작, 생략 시 true로 동작. html태그를 화면에 문자열로 찍음 -->
<c:out value = "<h3>escapeXml FALSE</h3>" escapeXml = "false"/> <!-- html태그를 태그로 동작시켜야 할 때, escape 설정을 통해 동작시킬 수 있음  -->

<br>
<a href = "ex02_result.jsp"> link </a>

</body>
</html>