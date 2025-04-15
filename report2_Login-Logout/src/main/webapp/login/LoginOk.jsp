<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 프로필 페이지 </h1>
<img src = "https://picsum.photos/id/1/200">

<% 
	//받아서 변수에 담기
	String userId=null;
	String userName=null;	
	String loginTime=null;
	if(session.getAttribute("userId")!=null){
		userId = session.getAttribute("userId").toString();
		userName = session.getAttribute("userName").toString();
		loginTime = session.getAttribute("loginTime").toString();		
		
	}else{
		session.setAttribute("loginError", "잘못된 접근입니다.");
		response.sendRedirect(request.getContextPath()+"/login/LoginForm.jsp");
	}
%>

<h3><%=userName%>님 반갑습니다!</h3>
<h3>최종 로그인 시각 : <%=loginTime%></h3>


<form method = "post" action = "<%= request.getContextPath() %>/LogoutServlet">
<button id = "button" type = "submit">로그아웃 버튼</button>
</form>
</body>
</html>