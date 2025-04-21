<%@page import="kosta.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:5px double red}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
 </style>

  <!-- script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script--><!-- JQuery 안씀 -->

  <script type="text/javascript">
     
  </script>

</head>

<body>


<div style="text-align: center">
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="view/memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="view/index.jsp">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
  </tr>
  
  <!--데이터 가져오기-->
   		<c:forEach var="dto" items="${list}" varStatus = "dtoStatus">
			<tr>
				<td>${dtoStatus.count}</td>
				<td><a href = "${pageContext.request.contextPath}/view/read.jsp?id=${dto.id}">${dto.id}</a></td>
				<td>${dto.pwd}</td>
				<td>${dto.name}</td>
				<td>${dto.age}</td>
				<td>${dto.addr}</td>
				<td>${dto.phone}</td>
				<td>${dto.joinDate}</td>	
				<td><form action = "${pageContext.request.contextPath}/delete"><button type = "submit" name = "id" value = "${dto.id}" > 삭제 </button></form></td>
			</tr>
		</c:forEach>    
</table>
<p>

<form name="search" action="${pageContext.request.contextPath}/search" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="submit" value="검색" />  

</form>

</div>

</body>
</html>




