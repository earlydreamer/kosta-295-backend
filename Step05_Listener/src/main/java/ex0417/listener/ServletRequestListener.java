package ex0417.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ServletRequestListener implements jakarta.servlet.ServletRequestListener {

	public ServletRequestListener() {
		System.out.println("Constructor init");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request");
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request destroy");
	}

}
