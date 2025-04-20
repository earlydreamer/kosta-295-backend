<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
	if (session.getAttribute("loginTime") instanceof Long) {
		long loginMillis = (Long) session.getAttribute("loginTime");
		session.setAttribute("loginDate", new java.util.Date(loginMillis));
	}
	//오로지 날짜 포맷팅만을 위한 임시 로직
	%>


	<div id="login_area">
		
		<!-- 로그인 안 되어있으면 로그인 폼 표시. iframe의 left 페이지를 갱신. 페이지 이동은 없다. -->
		<form id="login_form" method="post"
			action="${pageContext.request.contextPath}/Login" target="left">
			<label id="id_input_label">ID : </label><input id="user_id"
				name="user_id" required><br> <label id="pw_input_label">PWD
				: </label><input id="user_pw" name="user_pw" type="password" required><br>
			<button id="login_submit">로그인</button>
			<!--  >button id="cancel_button">취소</button-->
			<!--  로그인은 알겠는데 취소버튼은 왜있는거지 -->
		</form>
	</div>

	<div id="user_info" hidden>
		<c:if test="${not empty sessionScope.loginTime}">
			<label id = "welcome_text">${sessionScope.userId}님 반갑습니다!</label><br>
			<label id = "date"> <fmt:formatDate value="${sessionScope.loginDate}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</label>
			
			<!-- a href = "/Logout" target="left">로그아웃</a -->
			<!-- a태그는 POST 요청 할 수 없다 -->
			<form target = "left" method = "post" action = "${pageContext.request.contextPath}/Logout">
			<button name="logout_button" id = "logout_button">로그아웃</button>
			</form>
			
		</c:if>
	</div>

</body>

<script>
	
	let isLogin = "${not empty sessionScope.userId}";
	console.log()
	console.log("isLogin = ", isLogin);
	
	//로그인 여부에 따라 hidden 속성 갈아끼워주기
	if (isLogin==='true') {
		document.getElementById("login_area").hidden = true;
		document.getElementById("user_info").hidden = false;
	} else {
		document.getElementById("login_area").hidden = false;
		document.getElementById("user_info").hidden = true;

		//DOM에 의미없는 텍스트가 노출되지 않도록 텍스트 레이블의 내용을 빈 값으로 날려버린다
		//document.getElementById("welcome_text").innerText = "";
		//document.getElementById("date").innerText = "";
		
	}
	
	
	
</script>


</html>