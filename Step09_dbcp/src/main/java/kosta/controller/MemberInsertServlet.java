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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.NamingException;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	super.service(arg0, arg1);
    	MemberDAO dao = new MemberDaoImpl();
    	MemberDTO dto = null;
    	
    	String id=null;
    	String pw=null;
    	String name=null;
    	int age=0;
    	String phone = null;
    	String addr = null;
    	String joinDate = null;
    	
    	id = request.getParameter("id");
    	pw=request.getParameter("pwd");
    	name=request.getParameter("name");
    	age=Integer.parseInt(request.getParameter("age"));
    	phone=request.getParameter("phone");
    	addr = request.getParameter("addr");
    	dto = new MemberDTO(id,pw,name,age,phone,addr,"");//joinDate는 sql에서 now로 박음 비워놔도 된다
    	
    	//유효성 체크

    	//중복 체크
    	    	   	   	
    	
    	int re = dao.insert(dto);
    	
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
