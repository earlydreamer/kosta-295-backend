<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

<h1> 로그인 화면 </h1>

<form method="post" action="<%= request.getContextPath() %>/LoginServlet">
  ID : <input type="text" name="userId" required /><br> 
  PWD : <input type="password" name="userPwd" required/><br>
  NAME : <input type="text" name="userName" /><br>

  
  <!-- 이거 너무 지저분한데 깔끔하게 처리할 방법 없나... 최대한 js코드랑 jsp코드가 섞이지 않는 형태로 교통정리 -->
  <input type="submit" value="로그인" />

	<%
		String message="";//세션에 실려온 메시지를 담을 변수
		String loginError = (String) session.getAttribute("loginError");
		if(loginError!=null) message=loginError; //null이 아닐 경우 메시지를 실어 보낸다
	%>
	<script>
		let message = "<%= message.replace("\"", "\\\"") %>";
		if(message!=="") alert(message);//loginError가 null일 경우 공백 메시지가 넘어온다. 공백이면 alert를 찍지 않는다. 
	</script>
	<% if (loginError != null) session.removeAttribute("loginError"); //용도를 다한 loginError Attribute를 제거한다 %> 

 
</form>
</body>
</html>