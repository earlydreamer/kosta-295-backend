<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> ServletContext - application</h3>
<h3><%=application.getRealPath("/")%></h3><br>
<h3><%=application.getContextPath()%></h3><br>
<h3><%=application.getMajorVersion()%></h3><br>

<%
	//application에 정보 저장
	application.setAttribute("message","test");
	application.setAttribute("menus", Arrays.asList("메뉴1","메뉴2","메뉴3"));

	//session에 정보 저장
	session.setAttribute("id","1234test");
	
	//request에 정보 저장
	request.setAttribute("addr","주소");
	
%>


메시지:<%=application.getAttribute("message") %><br>
메뉴:<%=application.getAttribute("menus") %><br>

아이디:<%=session.getAttribute("id") %><br>
주소:<%=request.getAttribute("addr") %><br>

<a href = "application_get.jsp">확인하러 가 봅시다</a>
</body>
</html>