<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.Calendar" pageEncoding="UTF-8"%>
<!-- Page  지시어 : 이 언어는 Java 언어이며 html타입의 문서이다. 문자셋은 UTF-8을 사용한다. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Calendar now = Calendar.getInstance();
		String name = "test";
		out.print("<h3>"+name+"</h3>");
		out.print("<h3>"+now+"</h3>");
		//
		//이 영역은 Service 메소드 안이다	
		test(name);
		
	%>
	
	<%! //이 안에서는 전역변수 또는 메소드를 선언한다.
		//%! 안에서 선언된 요소들은 맨 위로 간다.	
	String name;
		String addr = "서울";
		public String test (String name){
			System.out.println(addr+"출력");
			this.name=name;
			return name;
		}
	%>

<h4> <%=addr %></h4>


</body>
</html>