package web.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
	}

	
	private Map<String,Controller> map;
	public void init(){
		System.out.println("dispatcherServlet.init...");
		ServletContext application = super.getServletContext();
		map = (Map<String,Controller>) application.getAttribute("map");
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String key = request.getParameter("key");
		System.out.println("test key = " + key);

		Controller con = map.get(key);
		ModelAndView mv = con.handleRequest(request, response);
		if (mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		} else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}

}
