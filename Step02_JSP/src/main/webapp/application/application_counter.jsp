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

	방문자 수 :
	<%=count%>

	<%--
	String s;
	int count = 0;
	if (application.getAttribute("count") == null)
		application.setAttribute("count", 0);

	s = application.getAttribute("count").toString();
	count = Integer.parseInt(s);

	/*잠재적으로 동기화 이슈가 발생할 여지가 있다. 같은 타이밍에 접속한 유저가 동시에 같은 Count 값을 읽어갔을 경우 덮어쓰기 이슈 발생 여지*/
	if (session.isNew())
		count++;
	application.setAttribute("count", count);
	--%>

</body>
</html>