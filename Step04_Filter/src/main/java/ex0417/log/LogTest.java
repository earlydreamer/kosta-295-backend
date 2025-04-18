package ex0417.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {

	Log log = LogFactory.getLog(super.getClass());
	
	
	public static void main(String args[]) {
		
		System.out.println("log-test");
		 
		new LogTest().test();
		
	}
	void test() {
		
		
		log.trace("trace log");
		log.debug("log debug");
		log.info("log info");
		log.warn("log warn");
		log.error("log error");
		log.fatal("log fatal");
		
		
		
		
	}
	
	
}
