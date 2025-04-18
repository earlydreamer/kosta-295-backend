<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<%
	String savedId = "";
	//쿠키에 저장된 id 넣기
		Cookie cookies [] = request.getCookies();
	//리퀘스트를 읽기 전에는 null일 수 있음
	if(cookies==null){
		out.println("쿠키 정보가 없습니다");
	}else
	{
		for(Cookie cookie : cookies){
			String name = cookie.getName();
			String value = cookie.getValue();
			if (name.equals("savedId")){//이 값이 쿠키에 있으면
				savedId = value;
				break;
			}
		}
		
	}

%>


<h1> 로그인 화면 </h1>

<form method="post" action="<%= request.getContextPath() %>/LoginServlet">
  ID : <input type="text" name="userId" required value = <%=savedId%> /><br> 
  PWD : <input type="password" name="userPwd" required/><br>
  NAME : <input type="text" name="userName" /><br>

  
  <!-- 이거 너무 지저분한데 깔끔하게 처리할 방법 없나... 최대한 js코드랑 jsp코드가 섞이지 않는 형태로 교통정리 -->
  <!-- EL 쓰면 될 거 같당... -->
  <input type="submit" value="로그인" />

	<%--
		String message="";//세션에 실려온 메시지를 담을 변수
		String loginError = (String) session.getAttribute("loginError");
		if(loginError!=null) message=loginError; //null이 아닐 경우 메시지를 실어 보낸다
	--%>

	<!-- 
	<script>
		let message = "<%= message.replace("\"", "\\\"") %>";
		if(message!=="") alert(message);//loginError가 null일 경우 공백 메시지가 넘어온다. 공백이면 alert를 찍지 않는다.
	</script>
	 -->
	<%-- if (loginError != null) session.removeAttribute("loginError"); //용도를 다한 loginError Attribute를 제거한다 --%> 

	
	<c:if test="${not empty sessionScope.loginError}">
	  <script>
	    let message = "${fn:replace(sessionScope.loginError, '\"', '\\\"')}";
	    if(message !== "") alert(message);
	  </script>
	  <c:remove var="loginError" scope="session" />
	</c:if>

 
</form>
</body>
</html>