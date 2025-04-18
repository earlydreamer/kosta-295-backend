<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<h1>프로필 페이지</h1>
	<img src="https://picsum.photos/id/1/200">

	<%
	response.setHeader("Cache-Control", "no-store");// 캐시 컨트롤 (열릴 때마다 다시 실행된다)
	session.setMaxInactiveInterval(60);// 세션 유지시간을 1분으로 변경

	//받아서 변수에 담기
	String userId = null;
	String userName = null;
	String loginTime = null;
	String lastLoginTime = null;

	long loginTimeLong;
	long lastLoginTimeLong;

	if (session.getAttribute("userId") != null) {
		userId = session.getAttribute("userId").toString();
		userName = session.getAttribute("userName").toString();
		loginTime = session.getAttribute("loginTime").toString();
		lastLoginTime = session.getAttribute("lastLoginTime").toString();

		loginTimeLong = Long.parseLong(loginTime);
		loginTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(loginTimeLong));

		if (lastLoginTime == null || lastLoginTime=="FIRSTLOGIN") //첫 로그인 플래그가 실려왔거나 null 상태이면(npe방지)
		{
			lastLoginTime = "첫 로그인입니다.";
		} else {
			lastLoginTimeLong = Long.parseLong(lastLoginTime);
			lastLoginTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new java.util.Date(lastLoginTimeLong));
		}

	} else {//필터에서 처리하므로 이 로직이 들어가면 중복이다. 용도를 다한 리다이렉트 코드 (리팩토링 시 제거 예정)
			//session.setAttribute("loginError", "잘못된 접근입니다.");
			//response.sendRedirect(request.getContextPath()+"/login_app/LoginForm.jsp");
	}
	%>

	<h1><%=userName%>님 반갑습니다!	</h3>
	<h3>
		지난 로그인 시각 :<%=lastLoginTime%><br>
		최종 로그인 시각 :<%=loginTime%>
		</h3>

	<form method="post"
		action="<%=request.getContextPath()%>/LogoutServlet">
		<button id="button" type="button">로그아웃 버튼</button>
		<script>
			const button = document.getElementById("button");
			button.addEventListener("click", function() {
				if (confirm("로그아웃하시겠습니까?")) {
					button.form.submit();
				} // else 아무것도 안함
			});
		</script>

	</form>
</body>
</html>