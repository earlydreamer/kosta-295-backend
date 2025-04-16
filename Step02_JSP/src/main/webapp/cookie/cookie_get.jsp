<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cookie get : Cookie page</h1>
<%
	Cookie cookies [] = request.getCookies();
	//리퀘스트를 읽기 전에는 null일 수 있음
	if(cookies==null){
		out.println("쿠키 정보가 없습니다");
	}else
	{
		out.println("쿠키 수 : "+cookies.length);
		
		for(Cookie cookie : cookies){
			String name = cookie.getName();
			String value = cookie.getValue();
			
			
			out.print("cookie name : "+name+"<br>");
			out.print("cookie value : "+value+"<br>");
		}
		
	}

%>
</body>
</html>