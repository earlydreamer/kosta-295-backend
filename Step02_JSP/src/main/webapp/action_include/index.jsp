<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<h1>Index.Jsp 파일입니다.</h1>

	<%
	String addr = "주소`2";
	%>

	<jsp:include page="footer.jsp">
		<jsp:param name="addr" value="<%=addr%>" />
		<jsp:param name="name" value="name" />
	</jsp:include>


</body>
</html>