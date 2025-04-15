package ex0415;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate(); // 세션 전체 제거
//		request.getSession().setAttribute("loginError", "로그아웃하였습니다.");
        response.sendRedirect(request.getContextPath() + "/login/LoginForm.jsp"); // 로그인 폼으로 이동

	}

	
	
}
