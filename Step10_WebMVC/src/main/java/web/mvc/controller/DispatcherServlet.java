package web.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String key = request.getParameter("key");
		System.out.println("test key = " + key);

		Controller con = null;

		if ("insert".equals(key)) {
			con = new InsertController();
		} else if ("select".equals(key)) {
			con = new SelectController();
		} else if ("update".equals(key)) {
			con = new UpdateController();
		} else if ("delete".equals(key)) {
			con = new DeleteController();
		} else {
			System.out.println();
		}
		ModelAndView mv = con.handleRequest(request, response);
		if (mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		} else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}

}
