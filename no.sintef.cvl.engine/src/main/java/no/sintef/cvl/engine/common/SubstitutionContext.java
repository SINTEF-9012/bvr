package no.sintef.cvl.engine.common;

import no.sintef.cvl.engine.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum SubstitutionContext {
	ME;
	private static final String configLocation = "META-INF/beans.xml";
	public ApplicationContext context;
	
	SubstitutionContext () {
		/*Spring initialization START*/
		context = new ClassPathXmlApplicationContext(new String[] {configLocation});
		/*Spring initialization END*/
	}
	
	public Logger getLogger(){
		return (Logger) this.context.getBean("defaultLogger");
	}
}
