<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>error page</h1>
	<h3>권한이 없습니다.</h3>
	${errorMsg}
	<p id='countDownMessage'>5초 후 로그인 페이지로 이동합니다...</p>

	<script>
		let countdown = 5;
		let countDownMessage = document.getElementById("countDownMessage");

		function setCountDown() {
			if (countdown > 0) {
				countDownMessage.innerText = `\${countdown}초 후 로그인 페이지로 이동합니다...`;
				countdown--;
				setTimeout(setCountDown, 1000);
			} else {
				window.location.href = "LoginForm.jsp";
			}
		}
		setCountDown();
	</script>
</body>
</html>