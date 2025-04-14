package ex0414.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private final String TEST_ID = "test";
	private final String TEST_PW = "1234";

	public LoginServlet() {
		System.out.println("Init Constructor");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet doPost call");

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");

		System.out.println("userId : " + userId);
		System.out.println("userName : " + userName);
		System.out.println("userPwd : " + userPwd);
//		super.doPost(request, response);
		
		if(TEST_ID.equals(userId) &&TEST_PW.equals((userPwd))){
			System.out.println("성공");
			//redirect 방식 : 새로운  request, response를 생성해서 이동
			response.sendRedirect("loginOk.jsp?userName=" + URLEncoder.encode(userName,"UTF-8")); // loginOk.jsp로 리다이렉트. root 밑에 있다.
			//get 방식의 queryString 형태로 데이터 전달
			
			//forward 방식 : request, response 데이터가 유지된다.
//			request.getRequestDispatcher("loginOk.jsp").forward(request, response);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("실패");
			PrintWriter out = response.getWriter();
			
			out.println("<script> alert('로그인에 실패했습니다');");
			out.println("history.back();");
//			out.println("location.href='LoginForm.html';");
			
			out.println("</script>");
			//WAS에서 던져도 loginForm이 먼저 갱신되어서 표시되지 않는다			
			
//			response.sendRedirect("LoginForm.html");
			
			
			
		}
		
	}

}
