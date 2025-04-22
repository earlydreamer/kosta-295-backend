package web.mvc.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//검색 기능
		
		//request로 전송된거 받음
		//service 호출 -> dao 호출
		//결과 받아서 뷰로 이동
		
		List<String> list= Arrays.asList("dd","aa","ss");
		request.setAttribute("list",list);
		return new ModelAndView("SelectResult.jsp");
		
	}

}
