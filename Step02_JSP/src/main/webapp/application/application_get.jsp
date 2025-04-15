<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


메시지:<%=application.getAttribute("message") %><br>
메뉴:<%=application.getAttribute("menus") %><br>

아이디:<%=session.getAttribute("id") %><br>
주소:<%=request.getAttribute("id") %><br>

</body>
</html>