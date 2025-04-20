<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="ko-kr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<body>

	<style>
#board_table, th, td {
	border: 1px solid gray;
	border-collapse: collapse;
}

#board_table th {
	background-color: orange;
}

#board_table td {
	text-align: center;
}
</style>

	board list
	<table id="board_table">
		<tr>
			<th>no.</th>
			<th>subject</th>
			<th>content</th>
		</tr>
		<c:forEach var="dto" items="${applicationScope.boardList}">
			<tr>
				<td>${dto.no}</td>
				<td>${dto.subject}</td>
				<td>${dto.content}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="board_input" hidden>
		<form method = "post" action = "${pageContext.request.contextPath}/Board" target = "center">
			<label id="number_input_label">번호</label>
				<input id="number_input" name="number_input" required><br>
			<label id="subject_input_label">제목</label>
				<input id ="subject_input" name="subject_input" required><br>
			<label id="content_input_label">본문</label>
				<input id="content_input" name="content_input" required><br>
			
			<button id="submit_board" type="submit">전송</button>

		</form>
	</div>

	<script>
		let isLogin = "${not empty sessionScope.userId}";

		if (isLogin === 'true') {
			document.getElementById("board_input").hidden = false;
		} else {
			document.getElementById("board_input").hidden = true;
		}
	</script>

</body>

</html>