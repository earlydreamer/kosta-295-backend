<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 쿠키 저장</h1>
	<%
		Cookie cookie1 = new Cookie("id","test");
		Cookie cookie2 = new Cookie("age","30");
		
		//쿠키의 옵션 설정
		cookie1.setMaxAge(60*60*24);//(초*분*시) = 1일
		cookie2.setMaxAge(60*60*24*365);//(초*분*시) = 1년
		
		cookie1.setPath("/"); // 모든 경로에서 접근 가능
				
		//클라이언트 측에 저장
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		
	%>
	
	<a href = "cookie_get.jsp">쿠키 확인하기</a>
	
</body>
</html>