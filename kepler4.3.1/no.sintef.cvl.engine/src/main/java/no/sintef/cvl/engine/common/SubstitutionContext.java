package no.sintef.cvl.engine.common;

import java.util.HashMap;

import no.sintef.cvl.common.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public enum SubstitutionContext {
	ME;
	private static final String configLocation = "META-INF/beans.xml";
	public ApplicationContext context;
	private EList<Resource> baseModel;
	private HashMap<Resource, ResourceContentCopier> copyBaseModelMap;
	private Logger logger;
	
	SubstitutionContext () {
		/*Spring initialization START*/
		context = new ClassPathXmlApplicationContext(new String[] {configLocation});
		/*Spring initialization END*/
		
		logger = (Logger) this.context.getBean("defaultLogger");
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	public void setLogger(Logger logger){
		this.logger = logger;
	}

	public EList<Resource> getBaseModel() {
		return baseModel;
	}

	public void setBaseModel(EList<Resource> baseModel) {
		this.baseModel = baseModel;
	}

	public HashMap<Resource, ResourceContentCopier> getCopyBaseModelMap() {
		return copyBaseModelMap;
	}

	public void setCopyBaseModelMap(HashMap<Resource, ResourceContentCopier> copyBaseModelMap) {
		this.copyBaseModelMap = copyBaseModelMap;
	}
}
