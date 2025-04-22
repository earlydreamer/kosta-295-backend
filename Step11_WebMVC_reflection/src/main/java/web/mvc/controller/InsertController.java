package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//전달된 정보를 받아서 vo또는 DTO로 만들고
		//service쪽으로 넘겨서 등록
		
		request.setAttribute("message","삽입완료 message");
		return new ModelAndView("updateResult.jsp");
	}

}
