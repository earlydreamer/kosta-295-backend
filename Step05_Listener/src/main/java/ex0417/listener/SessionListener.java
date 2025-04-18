package ex0417.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.websocket.Session;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    	System.out.println("SessionListener Constructor call..");
    	
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
//		HttpSessionListener.super.sessionCreated(se);
		System.out.println("sessionCreated call");
				
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
//		HttpSessionListener.super.sessionDestroyed(se);
		
		
		
		System.out.println("sessionDestroyed call");
		
		//session timeout 혹은 session.invalidate() 호출 시
		// 브라우저를 그냥 닫는 걸로는 세션이 종료되지 않음 -> 호출 안됨 (WAS에서는 사용자의 브라우저가 닫힌 것을 감지할 수 없다
		
				
	}

    
    
    
}
