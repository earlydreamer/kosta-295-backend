<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>test</h3>
메시지 : <%= application.getInitParameter("message") %><br>
ContextConfig : <%= application.getInitParameter("contextConfig") %><br>

</body>
</html>