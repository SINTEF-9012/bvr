/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.exception;

public class IllegalOperationException extends AbstractError{

	private static final long serialVersionUID = 5022403865689800189L;
	
	public IllegalOperationException(String msg) {
		super(msg);
	}

}
