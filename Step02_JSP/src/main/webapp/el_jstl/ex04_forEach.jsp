<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach test</title>
</head>
<body>
<h1> for each </h1>
<jsp:useBean id = "bean" class = "ex0416.ForEachBin"/>

<!--  
${bean.names}<br>
${bean.boardList}<br>
-->
<hr>

<form>
<!--  이름은 checkBox 출력  -->
<fieldset>
<legend>이름</legend>
<c:forEach items="${bean.names}" var = "name">
	<input type = "checkbox" name="name" value ="${name}" > ${name}
</c:forEach>
</fieldset>

<!--  메뉴는 selectBox 출력 -->

<fieldset>
<legend>메뉴</legend>
<select name="menu">
<c:forEach items = "${bean.menus}" var = "menu">	
	<option value = "${menu}"> ${menu}</option>
</c:forEach>
</select>
</fieldset>

<!--  boardList는 table로 출력 -->

<fieldset>
<style>
.table_board {
	border-collapse : collapse;
}

.table_board th{
	background-color:teal;
	color:white;
}
.table_board th,td{
border:1px solid black;
padding:6px;
}
</style>
<table class = 'table_board'>
	<th>번호</th>
	<th>제목</th>
	<th>내용</th>
<c:forEach items = "${bean.boardList}" var = "board">	
	<tr>
	<td>${board.number}</td>
	<td>${board.subject}</td>
	<td>${board.content}</td>
	</tr>
</c:forEach>
</table>
</fieldset>


<!--  map은 radioBox로 출력 -->

<fieldset>
<legend>국가 선택</legend>
<c:forEach items="${bean.map}" var = "map">
	<input type = "radio" name = "${map.key}" value = "${map.value}">
	${map.value}</input>
</c:forEach>
</fieldset>
</form>

</body>
</html>