package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardController implements Controller {

	//게시판 목록 조회
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BoardController.list Call..");
			
		request.setAttribute("message", "selectAll list");

		return new ModelAndView("view/board/list.jsp");

	}
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BoardController.read Call..");
		
		request.setAttribute("", "");
		
		request.setAttribute("message", "read post");
		
		
		return new ModelAndView("view/board/read.jsp");

	}
	
	
	//게시판 글 읽기
	
	
}
