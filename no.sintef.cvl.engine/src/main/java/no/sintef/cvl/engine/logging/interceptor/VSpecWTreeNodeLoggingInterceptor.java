package no.sintef.cvl.engine.logging.interceptor;

import org.aspectj.lang.JoinPoint;
import org.eclipse.emf.ecore.EClass;

import cvl.VPackageable;

import no.sintef.cvl.engine.logging.Logger;

public class VSpecWTreeNodeLoggingInterceptor {
	
	private Logger LOG;
	
	public void setLOG(Logger log){
		this.LOG = log;
	}
	
	public void addVarSpecBeforeAspect(JoinPoint jointPoint, VPackageable element){
		String message = jointPoint.getSignature().toString() + "tries to add " + element.getClass().getName();
		LOG.info(message);
	}
	
	public void getPropertyNameByClassBeforeAspect(JoinPoint jointPoint, String element){
		String message = "call by " + jointPoint.getSignature().toString() + " : for '" +element.toString() + "'";
		LOG.info(message);
	}
	
	public void getPropertyNameByClassAfterAspect(JoinPoint jointPoint, String retVal){
		String message = "call by " + jointPoint.getSignature().toString() + " :";
		if(retVal == null){
			LOG.info(message + "property is not whitelisted in VSpecWTreeNode");
		}else{
			LOG.info(message + "property '" + retVal + "' is whitelisted");
		}
	}

}
