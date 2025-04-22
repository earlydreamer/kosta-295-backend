package web.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import web.mvc.controller.Controller;

/**
 * Server 시작 시 각 컨트롤러를 미리 생성해 map 저장하고 application 영역에 저장 application 영역에 저장되므로
 * 모든 영역에서 컨트롤러에 접근할 수 있게 된다
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

	public HandlerMappingListener() {
	}

	public void contextInitialized(ServletContextEvent sce) {

		ResourceBundle rb = ResourceBundle.getBundle("actionMapping"); // resources/actionMapping.properties를 읽어온다
		Map<String, Controller> map = new HashMap<String, Controller>();

		// 루프 안에서 key와 value를 분리
		try {
			for (String key : rb.keySet()) {
				String value = rb.getString(key);
				System.out.println(key + "=" + value);

				Class<?> className = Class.forName(value); // Class의 Generic을 리턴한다
				Controller con = (Controller) className.getDeclaredConstructor().newInstance();
				map.put(key, con);
				System.out.println(key + value + con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		// value=객체로 만들고
		// map에 저장
		// 최종적으로 map을 application에 저장한다
		
		ServletContext application = sce.getServletContext();
		application.setAttribute("map", map);
		application.setAttribute("path", application.getContextPath());//path
		
	}

}
