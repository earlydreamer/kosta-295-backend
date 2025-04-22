package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Controller로 분류되는 구현체 회원관리
 */
public class UserController implements Controller {

	// login과 회원정보 수정 기능 필요

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("userController.login call..");
		
		HttpSession session = request.getSession();
		session.setAttribute("message","login-Test"); //세션에 정보 기록
		
		return new ModelAndView("view/user/login.jsp",true);

	}


	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("userController.updateUser call..");
		
		request.setAttribute("message","UpdateUserInfo-test"); //request에 실어서 보냄
		return new ModelAndView("view/user/update.jsp",true);

	}

}
