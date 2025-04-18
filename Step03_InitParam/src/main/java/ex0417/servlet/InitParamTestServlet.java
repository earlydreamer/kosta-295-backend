package ex0417.servlet;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {

	private String id;
	private String fileName;

	public InitParamTestServlet() {
		System.out.println("InitParamTestServlet call");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//<init-param>에서 선언된 것들은 이곳으로 넘어온다.		
		id=config.getInitParameter("id");;
		fileName=config.getInitParameter("fileName");		
		System.out.println("call init");
		
		//contextParam 정보 가져오기 - ServletContext 영역에 저장되어 있음
		//ServletContext를 가져와야함
		
		ServletContext application = config.getServletContext();
		String message = application.getInitParameter("message");
		String contextConfig = application.getInitParameter("contextConfig");
		
		System.out.println(message);
		System.out.println(contextConfig); 
		

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service call...");

	}

}
