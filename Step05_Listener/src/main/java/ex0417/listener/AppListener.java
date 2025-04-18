package ex0417.listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {
	
	
	public AppListener() {
	System.out.println("AppListener Constructor call..");	
	}
	
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//ServletContextListener.super.contextInitialized(sce);
		System.out.println("ContextInitialize call");
		//서버가 배포될때 동작함 (올라가면서 호출됨)
	
		//servlet context application 가져오기
		ServletContext application = sce.getServletContext();

		//context 선언
		application.setAttribute("count", new AtomicInteger()); //jsp에서 ${applicationscope.count}로 가져올 수 있다
		application.setAttribute("path", application.getContextPath()); //jsp에서 %{applicationscope.path}로 가져올 수 있다.
		
		
		
		
		
	}

	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//ServletContextListener.super.contextDestroyed(sce);
		
		System.out.println("ContextDestroy call");
		
	}

}
