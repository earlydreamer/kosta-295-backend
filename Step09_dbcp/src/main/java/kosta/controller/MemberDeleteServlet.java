package kosta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kosta.dao.MemberDAO;
import kosta.dao.MemberDaoImpl;
import kosta.dto.MemberDTO;

import java.io.IOException;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MemberDAO dao = new MemberDaoImpl();
    	String id = request.getParameter("id");
    	System.out.println(id);
    	int re = dao.delete(id);
    	if (re==0) {
    		request.setAttribute("errMsg", "error");
    		request.getRequestDispatcher("/view/error.jsp").forward(request, response);
    	}else {
    		System.out.println("ddd");
    		response.sendRedirect(request.getContextPath()+"/view/index.jsp");
    	}
    	//super.service(request, response);
    }
    
}
