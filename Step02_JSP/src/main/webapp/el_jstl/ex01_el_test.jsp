<%@page import="ex0416.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> EL(Expression Language) </h1>
	${5}<br>
	\${5} = ${5}<br>
	\${5+2} = ${5+2}<br>
	\${5*3} = ${5*3}<br>
	\${5 lt 3} = ${5 lt 3}<br>
	\${5>3} = ${5>3}<br>
	
	\${"테스트"} = ${"테스트"}<br>
	\${'테스트2'} = ${'테스트2'}<br>

	\${5 gt 3 and 10 eq 10 } = ${5 gt 3 and 10 eq 10}<br>
	${5>3?"크다":"작다"}<br>
	
	<!--  만약 http://localhost:8080/Step02_JSP/el_jstl/ex01_el_test.jsp?age=20 
		일 때 나이가 18 미만이면 미성년자 크면 성인이라고 출력한다고 했을때
	-->
	
	${param.age>=18?"성인":"미성년자"}<br>

	<!--  만약 http://localhost:8080/Step02_JSP/el_jstl/ex01_el_test.jsp?age=20&id="ddd" 
		일 때 나이가 18 미만이면 미성년자 크면 성인이라고 출력한다고 했을때
	-->
	
	${param.id!=null?param.id.concat("님"):"guest"}<br>
	${param.id!=null?param.id+="님":"guest"}<br>
	${not empty param.id?param.id:"guest"}<br>
	
	<%
		request.setAttribute("id","test");
		session.setAttribute("name","test1");
		session.setAttribute("addr","주소");
	
		application.setAttribute("addr","서울");
		application.setAttribute("message","EL test");
				
	%>
	
	<hr>

	<h3> scope에 있는 정보 조회</h3>
	
	아이디 : <%= request.getAttribute("id") %> / ${RequeqtScope.id} / ${id}
	이름 :  <%= session.getAttribute("name")%> / ${sessionScope.name} / ${name}
	주소 (session) : <%= session.getAttribute("addr")%> / ${sessionScope.addr} /${addr}
	주소 (application) : <%=application.getAttribute("addr")%> / ${sessionScope.addr } /${addr}	
	
	<hr>
	<%--
		Product p = new Product();
	--%>
	
	<jsp:useBean id = "p" class = "ex0416.Product"/>
	
	<h3>객체 EL에 접근</h3>

	상품 코드 : ${p.code}<Br> <!-- p.getCode()호출 -->
	상품 이름 : ${p.name}<br>
	상품 수량 : ${p.qty }<Br>
	상품 가격 : ${p.price }<Br>
	총 금액	: ${p.name }<Br>
	
	<hr>
	
	
	
	
</body>
</html>