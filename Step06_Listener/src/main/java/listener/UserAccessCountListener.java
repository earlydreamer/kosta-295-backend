package listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserAccessCountListener implements ServletContextListener, HttpSessionListener {

	ServletContext application;

	public UserAccessCountListener() {
		System.out.println("AccessCount Constructor call");
	}

	public void contextInitialized(ServletContextEvent e) {
		// server가 Start될 때 loginCount를 초기화한다.
		// application 영역에 초기화
		application = e.getServletContext();
		application.setAttribute("loginCount", new AtomicInteger());

	}

	public void sessionCreated(HttpSessionEvent e) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// session.invalidate() 혹은 session-timeout 시
		// loginCount 감소
		System.out.println(se.getSession().getAttribute("userId"));
		if (se.getSession().getAttribute("userId") != null) {
			AtomicInteger at = (AtomicInteger) application.getAttribute("loginCount");
			int loginCount = at.decrementAndGet();
			System.out.println("감소 후 loginCount = " + loginCount);
		}

	}

}
