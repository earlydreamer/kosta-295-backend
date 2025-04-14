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
			System.out.println("����");
			//redirect ��� : ���ο�  request, response�� �����ؼ� �̵�
			response.sendRedirect("loginOk.jsp?userName=" + URLEncoder.encode(userName,"UTF-8")); // loginOk.jsp�� �����̷�Ʈ. root �ؿ� �ִ�.
			//get ����� queryString ���·� ������ ����
			
			//forward ��� : request, response �����Ͱ� �����ȴ�.
//			request.getRequestDispatcher("loginOk.jsp").forward(request, response);
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("����");
			PrintWriter out = response.getWriter();
			
			out.println("<script> alert('�α��ο� �����߽��ϴ�');");
			out.println("history.back();");
//			out.println("location.href='LoginForm.html';");
			
			out.println("</script>");
			//WAS���� ������ loginForm�� ���� ���ŵǾ ǥ�õ��� �ʴ´�			
			
//			response.sendRedirect("LoginForm.html");
			
			
			
		}
		
	}

}
