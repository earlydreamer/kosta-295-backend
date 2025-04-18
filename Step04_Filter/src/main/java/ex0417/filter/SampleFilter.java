
package ex0417.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SampleFilter implements Filter {

	public SampleFilter(){
		System.out.println("Init filter...");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	System.out.println("init method...");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy...");
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)//request와 response가 자식에 있음... 다운캐스팅에서 구분되어야 할 수도 있음
			throws IOException, ServletException {
		
		//사전처리
		System.out.println("사전처리");
		
		chain.doFilter(req, res);//다음 타겟 호출 (필터일수도 서블릿일수도 jsp일수도 있음)
		//chain을 기점으로 사전과 사후로 구분
		//사후처리
		
		System.out.println("사후처리");
		
		

	}

}
