/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.exception;

public abstract class AbstractError extends RuntimeException {

	private static final long serialVersionUID = -3557729112973873095L;

	public AbstractError(String msg) {
		super(msg);
	}

	public AbstractError(String message, Throwable ex) {
		super(message, ex);
	}
	
	public AbstractError(Throwable ex) {
		super(ex);
	}
}
