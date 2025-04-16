<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<%
	String savedId = "";
	//쿠키에 저장된 id 넣기
	Cookie cookies[] = request.getCookies();
	//리퀘스트를 읽기 전에는 null일 수 있음
	if (cookies == null) {
		out.println("쿠키 정보가 없습니다");
	} else {
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if (name.equals("savedId")) {//이 값이 쿠키에 있으면
		savedId = value;
		break;
			}
		}
	}
	%>

	<h1>로그인 화면</h1>

	<div class='input-area'>
		<form class='input-form' method="post" action="<%=request.getContextPath()%>/LoginServlet">
		ID : <input type="text" name="userId" required value=<%=savedId%> /><br>
		PWD : <input type="password" name="userPwd" required /><br>
		NAME : <input type="text" name="userName" /><br> 
		
		<input type="submit" value="로그인" />

		<!-- EL 써서 가독성 개선 -->
		<c:if test="${not empty sessionScope.loginError}">
			<script>
			let message = "${fn:replace(sessionScope.loginError, '\"', '\\\"')}";
			if (message !== "")
				alert(message);
			</script>
			<c:remove var="loginError" scope="session" />
		</c:if>
	</form>
</body>
</html>