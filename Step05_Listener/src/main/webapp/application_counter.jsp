<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.concurrent.atomic.AtomicInteger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Object o;
 	int count;
	if (application.getAttribute("count") == null) {
		application.setAttribute("count", new AtomicInteger());
	}
	o = application.getAttribute("count");
	AtomicInteger i = (AtomicInteger) o;
	count = i.get();

	if (session.isNew()) {
		count = i.incrementAndGet();
	}
	
	%>

	방문자 수 : ${count} <%--=count--%>
	<br>
	contextPath : ${pageContext.request.contextPath} / <%=application.getContextPath() %> / ${path}


</body>
</html>