package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderController implements Controller {
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("OrderController.insert Call..");
		HttpSession session = request.getSession();
		session.setAttribute("message","select-result"); //세션에 정보 기록
		//등록 완료 후 동작
		return new ModelAndView("view/order/selectResult.jsp",true);//redirect 방식으로 보낼 거니까 true
		
	}
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("GoodsController.insert Call..");
		HttpSession session = request.getSession();
		session.setAttribute("message","insert-result"); //세션에 정보 기록

		//등록 완료 후 동작
		return new ModelAndView("view/order/insertResult.jsp",true);//redirect 방식으로 보낼 거니까 true
		
	}

}
