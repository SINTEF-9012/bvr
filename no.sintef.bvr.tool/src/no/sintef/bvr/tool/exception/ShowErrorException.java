/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.exception;

public class ShowErrorException extends AbstractError {


	private static final long serialVersionUID = 180309706713428656L;
	
	public ShowErrorException(String msg) {
		super(msg);
	}
	
	public ShowErrorException(String message, Throwable ex){
		super(message, ex);
	}
}
