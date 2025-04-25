package web.ajax.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/ajaxCheck")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		System.out.println("check doget");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(id+" "+name);
		
		response.getWriter().append("결과 Served at: ").append(request.getContextPath());
		
	}
	
	public void text(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/plain;charset=UTF-8");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
