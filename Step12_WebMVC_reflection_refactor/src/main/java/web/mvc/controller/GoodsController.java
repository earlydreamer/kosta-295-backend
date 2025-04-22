package web.mvc.controller;

import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoodsController implements Controller {

	//전체 상품 조회
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("GoodsController.list Call..");
		request.setAttribute("goodsList", Arrays.asList("goods1","goods2","goods3"));
		HttpSession session = request.getSession();
		
		return new ModelAndView("view/goods/list.jsp");
		
	}

	
	
	//상품 등록
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("GoodsController.insert Call..");
		HttpSession session = request.getSession();
		session.setAttribute("message","insert result"); //세션에 정보 기록
		//등록 완료 후 동작
		return new ModelAndView("view/goods/registerOk.jsp",true);//redirect 방식으로 보낼 거니까 true
		
	}
	
	
	
	
	
	
	
}
