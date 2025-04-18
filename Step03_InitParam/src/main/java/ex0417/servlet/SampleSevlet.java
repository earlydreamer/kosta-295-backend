package ex0417.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { 
		"/sample" }, initParams = { 
				@WebInitParam(name = "info", value = "점심메뉴"),
				@WebInitParam(name = "age", value = "20") 
		}, loadOnStartup = 1)

public class SampleSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SampleSevlet() {
		System.out.println("sampleServlet constructor call..");
	}

	public void init(ServletConfig config) throws ServletException {
		String id = config.getInitParameter("id");
		String fileName = config.getInitParameter("fileName");
		System.out.println("call init");

		// contextParam 정보 가져오기 - ServletContext 영역에 저장되어 있음
		// ServletContext를 가져와야함

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
