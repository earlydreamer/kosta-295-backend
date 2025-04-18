package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//@WebFilter("/LogFilter") //그냥 web.xml을 이용해서 제어
public class LogFilter extends HttpFilter implements Filter {

	public LogFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 접속자 IP, 접속 시도한 url 주소, 접속 소요 시간을 로그에 기록
		Log requestLog = LogFactory.getLog(super.getClass());

		HttpServletRequest httpRequest = (HttpServletRequest) request; // 자식 클래스 메소드 사용을 위해 casting

		String addr = httpRequest.getRemoteAddr().toString();
		if ("::1".equals(addr) || "0:0:0:0:0:0:0:1".equals(addr)) {
			addr = "127.0.0.1";
		}
		// localhost 접속 시 ipv6로 인식할 경우 강제로 127.0.0.1로 치환
		// tomcat의 기본 설정이 localhost 접속 시 ipv6로 인식하는 것으로 되어 있어서 ipv6 주소를 반환함
		// 한국 인터넷 환경상 디폴트 접속환경은 ipv4이므로, localhost를 제외한 ipv6 주소에 대응할 필요는 없다고 가정하고 구현

		addr = "ip 주소 : " + addr;

		String urlContext = "url : " + httpRequest.getRequestURL().toString();
		long startTime = System.currentTimeMillis();

		chain.doFilter(request, response);

		long endTime = System.currentTimeMillis();
		String spendTime = "소요 시간 = " + Long.toString(endTime - startTime) + "ms";

		requestLog.debug(addr);
		requestLog.debug(urlContext);
		requestLog.debug(spendTime);

	}

}
