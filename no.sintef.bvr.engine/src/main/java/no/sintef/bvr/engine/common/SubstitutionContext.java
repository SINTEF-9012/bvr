/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.common;

import java.util.HashMap;

import no.sintef.bvr.common.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.engine.logging.impl.ConsoleEngineLogger;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public enum SubstitutionContext {
	ME;
	private static final String configLocation = "META-INF/beans.xml";
	//public ApplicationContext context;
	private EList<Resource> baseModel;
	private HashMap<Resource, IResourceContentCopier> copyBaseModelMap;
	private Logger logger;
	
	SubstitutionContext () {
		/*Spring initialization START*/
		//context = new ClassPathXmlApplicationContext(new String[] {configLocation});
		/*Spring initialization END*/
		
		//logger = (Logger) this.context.getBean("defaultLogger");
		logger = new ConsoleEngineLogger();
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

	public HashMap<Resource, IResourceContentCopier> getCopyBaseModelMap() {
		return copyBaseModelMap;
	}

	public void setCopyBaseModelMap(HashMap<Resource, IResourceContentCopier> copyBaseModelMap) {
		this.copyBaseModelMap = copyBaseModelMap;
	}
}
