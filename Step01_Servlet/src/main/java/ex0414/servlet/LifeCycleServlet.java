package ex0414.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet 작성
 * public
 * HttpServlic 상속
 * 필요한 메소드 재정의해서 기능 작성
 * 생성+mapping
 * web.xml 혹은 @annotation 설정
 * 
 */

public class LifeCycleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("call doGet");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title> test </title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1 style = 'color:red'> test <h1>");		
		out.print("</body>");
		out.print("</html>");
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("call doPost");
		}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("call service");
		// 원래의 sevice가 오버라이딩되어 doPost 혹은 doGet이 동작하지 않는다
//		super.service(request,response);  
	}

	@Override
	public void destroy() {
		System.out.println("call destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("call init");
	}

	public LifeCycleServlet() {
		System.out.println("call constructor");
	}


	
}
