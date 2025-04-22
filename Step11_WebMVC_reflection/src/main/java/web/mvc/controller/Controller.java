package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * DispatcherService의 일을 위임받음 위임받은 요청을 처리해줄 공통의 메소드 정의 얘를 상속받은 구현체들이 기능을 제공함
 * 
 */
public interface Controller {

	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; //service에서 처리하는 매개변수와 예외 동일하게 등록

	
}
