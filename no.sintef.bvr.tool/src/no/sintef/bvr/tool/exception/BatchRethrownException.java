/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.exception;

public class BatchRethrownException extends RethrownException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1935419948423968521L;
	
	
	public BatchRethrownException(String msg) {
		super(msg);
	}
	
	public BatchRethrownException(Throwable ex) {
		super(ex);
	}
	
	public BatchRethrownException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
