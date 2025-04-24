package web.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
	}

	private Map<String, Controller> map;
	private Map<String, Class<?>> classMap;

	public void init() {
		System.out.println("dispatcherServlet.init...");
		ServletContext application = super.getServletContext();
		map = (Map<String, Controller>) application.getAttribute("map");
		classMap = (Map<String, Class<?>>) application.getAttribute("classMap");

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		System.out.println("test key = " + key);

		Controller con = map.get(key);
		Class<?> className = classMap.get(key);
		
		//key가 null일 때 default값을 넣어주기
		
		// Reflection을 이용한 메소드 실행
		try {
			Method method = className.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

			ModelAndView mv = (ModelAndView) method.invoke(con, request, response);
			if (mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erorMsg", e.getCause().getMessage());//원인을 받아서 찍음
			request.getRequestDispatcher("error/error.jsp");
			//error 있을 경우 error.jsp로 redirect(forward)
			//error 타입에 따라 error메시지 전달
		}
	}

}
