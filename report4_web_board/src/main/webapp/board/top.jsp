<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<style>
			* {
			margin: 0;
			padding: 0;
			box-sizing: border-box;
		}
		.toparea-menu ul{
			display:flex;
			list-style: none;
			justify-content: flex-start;
			align-items: center;
			flex-direction: row;
			gap:20px;
		}

	</style>

		<div class='toparea-menu'>
			<ul>
				<li><a href= "${pageContext.request.contextPath}/board/board.jsp" target="center">게시판</a></li>
				<li><a href="${pageContext.request.contextPath}/board/mypage.jsp" target="center">mypage</a></li>
				<li><a href="${pageContext.request.contextPath}/board/qna.jsp"target="center">q&a</a></li>
			</ul>
		</div>
		
	</html>