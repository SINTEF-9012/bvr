package no.sintef.cvl.engine.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.sintef.cvl.engine.common.Engine;

public class MainRunEngine {

	private static final String configLocation = "META-INF/beans.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Spring initialization START*/
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {configLocation});
		/*Spring initialization END*/
		
		Engine engine = new Engine();
		engine.run();
	}

}
