<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 로그인 화면 </h1>

<form method="post" action="<%= request.getContextPath() %>/LoginServlet">
  ID : <input type="text" name="userId" required /><br> 
  PWD : <input type="password" name="userPwd" required/><br>
  NAME : <input type="text" name="userName" /><br>

  
  <!-- 이거 너무 지저분한데 깔끔하게 처리할 방법 없나 -->
  <input type="submit" value="로그인" />

	<%String loginError = (String) session.getAttribute("loginError");
	    if (loginError != null) {
	%>
	<script>alert("<%= loginError %>");</script>
	<%
	        session.removeAttribute("loginError");
	    }
	%>

</form>

</body>
</html>