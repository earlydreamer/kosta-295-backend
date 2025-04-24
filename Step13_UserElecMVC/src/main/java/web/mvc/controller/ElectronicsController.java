package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ElectronicsController implements Controller {

	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BoardController.read Call..");
		request.setAttribute("message", "read post");		
		return new ModelAndView("elec/read.jsp");

	}
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("elec/list.jsp");
	}
	
	
}
