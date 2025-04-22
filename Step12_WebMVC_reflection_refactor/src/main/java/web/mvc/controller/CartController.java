package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartController implements Controller {

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("CartController.insert Call..");
		
		//등록 완료 후 동작
		return new ModelAndView("view/cart/selectResult.jsp",true);//redirect 방식으로 보낼 거니까 true
		
	}
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("CartController.insert Call..");
		
		//등록 완료 후 동작
		return new ModelAndView("view/cart/insertResult.jsp",true);//redirect 방식으로 보낼 거니까 true
		
	}
	
}
