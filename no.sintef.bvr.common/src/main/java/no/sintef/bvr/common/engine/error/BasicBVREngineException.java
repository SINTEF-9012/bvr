/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.common.engine.error;

/**
 * Basic BVR Engine exception
 *
 */
public class BasicBVREngineException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -527394920492914850L;
	private String message;

	public BasicBVREngineException(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	
}
