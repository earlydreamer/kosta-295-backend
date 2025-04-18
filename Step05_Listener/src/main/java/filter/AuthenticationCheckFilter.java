package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter("/AuthenticationCheckFilter") // 그냥 web.xml을 이용해서 제어
public class AuthenticationCheckFilter extends HttpFilter implements Filter {
       
	private final String ERROR_PATH = "/login_app/error/";//나중에 properties 사용하는 방식으로 리팩토링...

	public AuthenticationCheckFilter() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request; // 자식 클래스 메소드 사용을 위해 casting
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		if(session.getAttribute("userId")==null){
			httpRequest.setAttribute("errorMsg","로그인 후 다시 시도해 주세요.");
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(ERROR_PATH+"errorPage.jsp");
			dispatcher.forward(httpRequest, httpResponse); // forward방식으로 이동 
		}
		
		chain.doFilter(request, response);
	}


}
