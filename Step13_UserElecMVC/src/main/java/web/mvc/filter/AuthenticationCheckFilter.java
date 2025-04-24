package web.mvc.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class AuthenticationCheckFilter
 */
@WebFilter("/auth")
public class AuthenticationCheckFilter extends HttpFilter implements Filter {

	/**
	 * Default Initializer
	 */
	public AuthenticationCheckFilter() {
        super();
    }

	/**
	 * Filter 동작
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request로 들어온 session 정보 확인
		//session 정보가 있으면 dofilter
		//없으면 throw new AuthenticationException
		
		chain.doFilter(request, response);
		
	}
}
