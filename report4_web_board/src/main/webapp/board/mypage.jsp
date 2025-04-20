<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  마이페이지에 대한 별도 지시사항이 없었으므로 일단 적당한 빈 페이지 생성함 -->
	마이페이지
	<div id = 'mypage-area' hidden></div>
	<div id = 'login-please'></div>
</body>
<script>
	let isLogin = false;
	// if 세션 정보가 있으면 mypage-area true else login-please 활성화
	if (isLogin){
		document.getElementById("mypage-area").hidden = false;
		document.getElementById("login-please").hidden = true;
	}else{
		document.getElementById("mypage-area").hidden = true;
		document.getElementById("login-please").hidden = false;
	}

</script>
</html>